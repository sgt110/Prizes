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
 * 返回模型
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-22 15:50
 */
public class Result<T> extends AbstractResultModel {
    private T data;

    public Result() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <E> Result<E> success(E data) {
        Result<E> result = new Result<E>();
        result.setData(data);
        return result;
    }

    public static Result failure(String code, String message) {
        Result result = new Result();
        result.setMessage(message);
        result.setCode(code);
        return result;
    }
}
