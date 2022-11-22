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
package com.sgt.prizes.common.handler;

import com.sgt.prizes.common.ExceptionCode;
import com.sgt.prizes.common.PrizesException;
import com.sgt.prizes.common.Result;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常捕捉
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-22 16:19
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理抛出异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = PrizesException.class)
    @ResponseBody
    public Result prizesExceptionHandler(PrizesException e) {
        log.error("抽奖业务异常！原因是:", e);
        return Result.failure(e.getCode(), e.getMessage());
    }

    /**
     * 处理其他异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        log.error("未知异常！原因是:", e);
        return Result.failure(ExceptionCode.UNKNOWN_ERROR.code(), e.getMessage());
    }
}
