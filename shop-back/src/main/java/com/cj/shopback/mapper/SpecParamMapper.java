package com.cj.shopback.mapper;

import com.cj.shopback.model.SpecParam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity com.cj.shopback.model.SpecParam
 */
public interface SpecParamMapper extends BaseMapper<SpecParam> {

    List<SpecParam> getParamsBySpuId(Integer id);
}




