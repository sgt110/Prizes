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
package com.sgt.prizes;

import java.math.BigDecimal;
import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-21 18:02
 */
public class SgtTest {

    @Test
    public void test1(){

        for (int i = 0;i<1000;i++){
            //获取随机数
            Random random = new Random();
            int num = random.nextInt(9999);
            BigDecimal randNum = new BigDecimal(num).divide(new BigDecimal(10000));
            System.out.println(randNum);
        }
    }
    @Test
    public void test2(){
        BigDecimal num = new BigDecimal(1998).divide(new BigDecimal(10000), 4, BigDecimal.ROUND_HALF_UP);

        System.out.println(num.compareTo(new BigDecimal("0.2")));

    }
}
