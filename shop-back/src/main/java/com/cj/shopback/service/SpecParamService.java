package com.cj.shopback.service;

import com.cj.shopback.model.SpecParam;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface SpecParamService extends IService<SpecParam> {

    List<SpecParam> getParamsBySpuId(Integer id);
}
