/*
 * Project: Prizes
 *
 * File Created at 2022-11-22
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
package com.sgt.prizes.service.prizes.transform;

import com.sgt.prizes.dal.prizes.po.PrizesPO;
import com.sgt.prizes.dal.prizeslevel.po.PrizesLevelPO;
import com.sgt.prizes.service.prizes.bo.PrizesBO;
import com.sgt.prizes.service.prizes.bo.PrizesLevelBO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-22 15:22
 */
public class PrizesTransform {

    public static PrizesBO transPo2Bo(PrizesPO source) {
        if (source == null) {
            return null;
        }
        PrizesBO target = new PrizesBO();
        target.setId(source.getId());
        target.setPrizesName(source.getPrizesName());
        target.setPrizesDesc(source.getPrizesDesc());
        target.setPrizesLevelId(source.getPrizesLevelId());
        target.setPrizesNum(source.getPrizesNum());
        target.setPrizesWeight(source.getPrizesWeight());
        target.setPicUrl(source.getPicUrl());
        return target;
    }

    public static PrizesLevelBO transPo2Bo(PrizesLevelPO source) {
        if (source == null) {
            return null;
        }
        PrizesLevelBO target = new PrizesLevelBO();
        target.setId(source.getId());
        target.setPrizesLevelName(source.getPrizesLevelName());
        target.setPrizesLevelDesc(source.getPrizesLevelDesc());
        target.setPrizesLevelProbability(source.getPrizesLevelProbability());
        target.setIsDeleted(source.getIsDeleted());
        target.setGmtCreated(source.getGmtCreated());
        target.setGmtModified(source.getGmtModified());
        return target;
    }

    public static List<PrizesLevelBO> transListPo2Bo(List<PrizesLevelPO> sourceList){
        if (CollectionUtils.isEmpty(sourceList)){
            return Collections.emptyList();
        }
        return sourceList.stream().map(PrizesTransform::transPo2Bo).collect(Collectors.toList());
    }
}
