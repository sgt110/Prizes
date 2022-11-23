package com.sgt.prizes.dal.prizesrecord.po;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * 奖品表
 * @author sungt
 * @TableName prizes_record
 */
@Data
@Builder
public class PrizesRecordPO implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 抽奖操作者（因为没搞登录系统，所以暂定直接写System）
     */
    private String prizesRecordUser;

    /**
     * 奖品ID
     */
    private Integer prizesId;

    /**
     * 奖品等级ID
     */
    private Integer prizesLevelId;

    /**
     * 抽奖时间
     */
    private Date prizesRecordTime;

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