package com.sgt.prizes.dal.prizeslevel.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 奖品表
 * @TableName prizes_level
 */
@Data
public class PrizesLevelPO implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 奖品等级名字
     */
    private String prizesLevelName;

    /**
     * 等级描述
     */
    private String prizesLevelDesc;

    /**
     * 奖品等级概率
     */
    private BigDecimal prizesLevelProbability;

    /**
     * 是否删除，1，删除，0：不删除
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改时间
     */
    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}