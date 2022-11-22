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
 * @since 2022-11-21 16:42
 */
public interface ResultCode {
    String SYS = "SYS";
    String COMMON = "C";
    String AUTH = "AUTH";

    String code();

    String message();
}
