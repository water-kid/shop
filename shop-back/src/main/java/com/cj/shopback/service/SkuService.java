package com.cj.shopback.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.shopback.model.Sku;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface SkuService extends IService<Sku> {

    IPage<Sku> getPageSku(Page<Sku> of, Sku sku);

    boolean batchDeleteByIds(List<Integer> ids);
}
