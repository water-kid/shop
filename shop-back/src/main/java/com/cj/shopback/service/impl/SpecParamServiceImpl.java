package com.cj.shopback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cj.shopback.model.SpecParam;
import com.cj.shopback.service.SpecParamService;
import com.cj.shopback.mapper.SpecParamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SpecParamServiceImpl extends ServiceImpl<SpecParamMapper, SpecParam>
    implements SpecParamService{

    @Autowired
    SpecParamMapper specParamMapper;

    @Override
    public List<SpecParam> getParamsBySpuId(Integer id) {
        return specParamMapper.getParamsBySpuId(id);
    }
}




