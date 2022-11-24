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
package com.sgt.prizes.controller;

import com.sgt.prizes.common.Result;
import com.sgt.prizes.service.prizes.PrizesService;
import com.sgt.prizes.service.prizes.bo.PrizesBO;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 抽奖！
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-22 15:45
 */
@RestController
@RequestMapping("/sgt/prizes")
public class PrizesController {

    @Resource
    private PrizesService prizesService;

    /**
     * 单抽出奇迹
     *
     * @return
     */
    @PostMapping("/one")
    public Result<PrizesBO> prizesOne() {
        return Result.success(prizesService.lottery());
    }

    /**
     * 十连抽
     *
     * @return
     */
    @PostMapping("/ten")
    public Result<List<PrizesBO>> prizesTen() {
        return Result.success(prizesService.lotteryTen());
    }

}
