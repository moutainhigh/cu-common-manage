package com.aotain.common.policyapi.mapper;

import com.aotain.common.config.annotation.MyBatisDao;
import com.aotain.common.policyapi.base.BaseMapper;
import com.aotain.common.policyapi.model.AreaGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Demo class
 *
 * @author daiyh@aotain.com
 * @date 2017/12/20
 */
@MyBatisDao("areaGroupMappers")
public interface AreaGroupMapper extends BaseMapper{

    int deleteDataByMessageNo(Long messageNo);

    List<AreaGroup> selectSour(Long messageNo);
    List<AreaGroup> selectDest(Long messageNo);

    List<AreaGroup> selectOne(@Param("messageNo")Long messageNo, @Param("areaId")Long areaId);
}
