package com.cj.shopback.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.shopback.model.Sku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Entity com.cj.shopback.model.Sku
 */
public interface SkuMapper extends BaseMapper<Sku> {

    IPage<Sku> selectPageByDto(Page<Sku> of,@Param("sku") Sku sku);

    int addSku(Sku sku);
}




