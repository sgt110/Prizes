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
package com.sgt.prizes.service.prizes;

import com.sgt.prizes.service.prizes.bo.PrizesBO;

import java.util.List;

/**
 * 抽奖service
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-14 18:02
 */
public interface PrizesService {

    /**
     * 单抽
     * @return 返回奖品数据
     */
    PrizesBO lottery();

}
