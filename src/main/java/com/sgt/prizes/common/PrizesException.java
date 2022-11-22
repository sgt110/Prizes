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

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-21 16:39
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PrizesException extends RuntimeException {
    protected String code;

    public PrizesException() {
    }

    public PrizesException(Throwable cause) {
        super(cause);
        if (cause instanceof PrizesException) {
            this.code = ((PrizesException)cause).getCode();
        } else {
            this.code = ExceptionCode.UNKNOWN_ERROR.code();
        }

    }

    public PrizesException(String code, String message) {
        super(message);
        this.code = code;
    }

    public PrizesException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public PrizesException(ServiceCode respCode) {
        super(respCode.message());
        this.code = respCode.code();
    }

    public PrizesException(ServiceCode respCode, Throwable cause) {
        super(respCode.message(), cause);
        this.code = respCode.code();
    }
}
