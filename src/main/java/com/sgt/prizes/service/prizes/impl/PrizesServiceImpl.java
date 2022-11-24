/*
 * Project: Prizes
 *
 * File Created at 2022-11-14
 *
 * Copyright 2012-2015 Greenline.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Greenline Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Greenline.com.
 */
package com.sgt.prizes.service.prizes.impl;

import com.sgt.prizes.common.ExceptionCode;
import com.sgt.prizes.dal.prizes.PrizesMapper;
import com.sgt.prizes.dal.prizes.po.PrizesPO;
import com.sgt.prizes.dal.prizeslevel.PrizesLevelMapper;
import com.sgt.prizes.dal.prizeslevel.po.PrizesLevelPO;
import com.sgt.prizes.dal.prizesrecord.PrizesRecordMapper;
import com.sgt.prizes.dal.prizesrecord.po.PrizesRecordPO;
import com.sgt.prizes.service.prizes.PrizesService;
import com.sgt.prizes.service.prizes.bo.PrizesBO;
import com.sgt.prizes.service.prizes.bo.PrizesLevelBO;
import com.sgt.prizes.service.prizes.bo.PrizesLinkList;
import com.sgt.prizes.service.prizes.transform.PrizesTransform;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 抽奖impl
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-14 18:02
 */
@Service
@Slf4j
public class PrizesServiceImpl implements PrizesService {

    @Resource
    private PrizesLevelMapper prizesLevelMapper;

    @Resource
    private PrizesMapper prizesMapper;

    @Resource
    private PrizesRecordMapper prizesRecordMapper;

    @Override
    public PrizesBO lottery() {

        //获取全部抽奖等级
        List<PrizesLevelPO> levelBoList = prizesLevelMapper.selectAll();
        BigDecimal total = levelBoList.stream().map(PrizesLevelPO::getPrizesLevelProbability)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        if (!total.equals(new BigDecimal("1.0000"))) {
            throw ExceptionCode.PRIZES_PROBABILITY.error();
        }

        PrizesLinkList levelLink = sortPrizesLevel(PrizesTransform.transListPo2Bo(levelBoList));
        //获取随机数
        Random random = new Random();
        int num = random.nextInt(10000);
        BigDecimal randNum = new BigDecimal(num).divide(new BigDecimal(10000), 4, BigDecimal.ROUND_HALF_UP);
        PrizesLevelBO prizesBO = getRandPrizes(randNum, levelLink);
        //获取具体奖品
        //此处在高并发下应该加上锁
        List<PrizesPO> prizesPoList = prizesMapper.listInStockByLevelId(prizesBO.getId());
        int allWeight = prizesPoList.stream().mapToInt(PrizesPO::getPrizesWeight).sum();
        //权重随机数
        Integer randNum2 = getRandomInt(allWeight + 1);
        PrizesPO[] prizesPoS = new PrizesPO[allWeight];
        int left = 0;
        for (PrizesPO po : prizesPoList) {
            for (int i = left; i < po.getPrizesWeight() + left; i++) {
                prizesPoS[i] = po;
            }
            left += po.getPrizesWeight();
        }
        PrizesPO returnPrizes = prizesPoS[randNum2 - 1];
        //扣减库存
        deductionInventory(returnPrizes);
        //记录数据
        saveRecord(returnPrizes);

        return PrizesTransform.transPo2Bo(returnPrizes);
    }

    @Override
    public List<PrizesBO> lotteryTen() {
        List<PrizesBO> boList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            PrizesBO bo = lottery();
            boList.add(bo);
        }

        return boList;
    }

    private void saveRecord(PrizesPO returnPrizes) {
        PrizesRecordPO recordPO = PrizesRecordPO.builder().prizesId(returnPrizes.getId()).prizesLevelId(
            returnPrizes.getPrizesLevelId()).prizesRecordUser("system").prizesRecordTime(new Date()).build();
        prizesRecordMapper.insert(recordPO);
    }

    private Boolean deductionInventory(PrizesPO returnPrizes) {
        if (returnPrizes.getPrizesNum() == -1){
            return Boolean.TRUE;
        }
        int num = prizesMapper.deductionInventory(returnPrizes.getId());
        if (num > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


    private PrizesLevelBO getRandPrizes(BigDecimal randNum, PrizesLinkList levelLink) {
        if (levelLink.getMinNum().compareTo(randNum)< 0 && levelLink.getNextNode() == null){
            return levelLink.getLevelBO();
        }else if (levelLink.getMinNum().compareTo(randNum)< 0 && levelLink.getNextNode().getMinNum().compareTo(randNum)>=0){
            return levelLink.getLevelBO();
        }else {
            return getRandPrizes(randNum, levelLink.getNextNode());
        }
    }

    private PrizesLinkList sortPrizesLevel(List<PrizesLevelBO> levelBoList) {
        PrizesLinkList linkList = null;
        PrizesLinkList next = null;
        BigDecimal nowProbability = BigDecimal.ZERO;
        for (PrizesLevelBO bo : levelBoList) {
            if (linkList == null) {
                PrizesLinkList nowNode = new PrizesLinkList();
                nowNode.setMinNum(nowProbability);
                nowNode.setLevelBO(bo);
                linkList = nowNode;
                next = linkList;
            } else {
                PrizesLinkList nowNode = new PrizesLinkList();
                nowNode.setMinNum(next.getMinNum().add(next.getLevelBO().getPrizesLevelProbability()));
                nowNode.setLevelBO(bo);
                next.setNextNode(nowNode);
                next = nowNode;
            }

        }
        return linkList;
    }

    public Integer getRandomInt(int bound) {
        int num = 0;
        do {
            Random random = new Random();
            num = random.nextInt(bound);
        } while (num == 0);
        return num;
    }
}
