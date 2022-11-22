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
package com.sgt.prizes.common;

/**
 * 返回模型抽象类
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-22 15:48
 */
public abstract class AbstractResultModel {
    public static final String SUCCESS = "0";
    private String code = "0";
    private String message = "成功";

    public AbstractResultModel() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
