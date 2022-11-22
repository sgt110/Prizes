/*
 * Project: Prizes
 *
 * File Created at 2022-11-21
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
package com.sgt.prizes.service.prizes.bo;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 抽奖概率链表
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-21 17:12
 */
@Data
public class PrizesLinkList {

    /**
     * 最小值
     */
    private BigDecimal minNum;

    /**
     * 奖品等级
     */
    private PrizesLevelBO levelBO;

    /**
     * 下一个节点
     */
    private PrizesLinkList nextNode;
}
