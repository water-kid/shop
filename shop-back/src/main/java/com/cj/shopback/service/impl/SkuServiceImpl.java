package com.cj.shopback.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cj.shopback.model.Sku;
import com.cj.shopback.service.SkuService;
import com.cj.shopback.mapper.SkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku>
    implements SkuService{

    @Autowired
    SkuMapper skuMapper;

    @Override
    public IPage<Sku> getPageSku(Page<Sku> of, Sku sku) {
        return skuMapper.selectPageByDto(of,sku);
    }

    @Override
    @Transactional
    public boolean batchDeleteByIds(List<Integer> ids) {
        int row = skuMapper.deleteBatchIds(ids);
        if (row==ids.size()){
            return true;
        }
        return false;
    }
}




