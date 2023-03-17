package com.cj.shopback.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.shopback.model.Spu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface SpuService extends IService<Spu> {

    List<Spu> getAllSpu();

    IPage<Spu> getPageSpu(Page<Spu> of, Spu spu);
}
