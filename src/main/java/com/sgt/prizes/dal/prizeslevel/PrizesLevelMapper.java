package com.sgt.prizes.dal.prizeslevel;

import com.sgt.prizes.dal.prizeslevel.po.PrizesLevelPO;
import com.sgt.prizes.service.prizes.bo.PrizesLevelBO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
* @author sungt
* @description 针对表【prizes_level(奖品表)】的数据库操作Mapper
* @createDate 2022-11-21 15:46:07
* @Entity com.sgt.prizes.dal.prizeslevel.po.PrizesLevelPO
*/
public interface PrizesLevelMapper {

    List<PrizesLevelPO> selectAll();

}




