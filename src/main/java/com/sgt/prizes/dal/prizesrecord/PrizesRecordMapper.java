package com.sgt.prizes.dal.prizesrecord;

import com.sgt.prizes.dal.prizesrecord.po.PrizesRecordPO;

import org.apache.ibatis.annotations.Param;

/**
* @author sungt
* @description 针对表【prizes_record(奖品表)】的数据库操作Mapper
* @createDate 2022-11-23 11:05:47
* @Entity com.sgt.prizes.dal.prizesrecord.po.PrizesRecordPO
*/
public interface PrizesRecordMapper {

    /**
     * 插入
     * @param po
     * @return 影响行数
     */
    int insert(@Param("po") PrizesRecordPO po);
}




