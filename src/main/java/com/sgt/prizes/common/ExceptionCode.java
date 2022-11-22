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
package com.sgt.prizes.common;

/**
 * 异常代码枚举
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-21 16:42
 */
public enum ExceptionCode implements ServiceCode {
    /**
     * 异常Code
     */
    UNKNOWN_ERROR("1", "未知的系统错误"),
    /**
     * 抽奖异常
     */
    PRIZES_PROBABILITY("1001", "概率异常！"),
    ;

    private final String code;
    private final String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    ExceptionCode(String code, String codeSign, String message) {
        this.code = codeSign + "_" + code;
        this.message = message;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }

    public PrizesException error() {
        return new PrizesException(this);
    }

    public PrizesException error(Throwable cause) {
        return new PrizesException(this, cause);
    }
}
