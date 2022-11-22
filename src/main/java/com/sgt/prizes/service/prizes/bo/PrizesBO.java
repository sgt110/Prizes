package com.sgt.prizes.service.prizes.bo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 奖品表
 * @author sungt
 * @TableName prizes
 */
@Data
public class PrizesBO implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 奖品名字
     */
    private String prizesName;

    /**
     * 奖品描述
     */
    private String prizesDesc;

    /**
     * 奖品等级ID
     */
    private Integer prizesLevelId;

    /**
     * 奖品数量（-1：无限）
     */
    private Integer prizesNum;

    /**
     * 奖品权重
     */
    private Integer prizesWeight;

    /**
     * 图片地址
     */
    private String picUrl;

    private static final long serialVersionUID = 1L;
}