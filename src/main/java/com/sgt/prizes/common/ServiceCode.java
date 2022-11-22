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
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-21 16:41
 */
public interface ServiceCode extends ResultCode {
    default PrizesException failure() {
        return new PrizesException(this);
    }

    default PrizesException failure(Throwable cause) {
        return new PrizesException(this, cause);
    }
}