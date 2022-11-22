package com.sgt.prizes.dal.prizes;

import com.sgt.prizes.dal.prizes.po.PrizesPO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
* @author sungt
* @description 针对表【prizes(奖品表)】的数据库操作Mapper
* @createDate 2022-11-21 15:42:17
* @Entity com.sgt.prizes.dal.prizes.Prizes
*/
public interface PrizesMapper {

    /**
     * 根据奖品等级ID获取具体奖品列表
     *
     * @param prizesLevelId 奖品等级ID
     * @return 具体奖品列表
     */
    List<PrizesPO> listByLevelId(Integer prizesLevelId);
}




