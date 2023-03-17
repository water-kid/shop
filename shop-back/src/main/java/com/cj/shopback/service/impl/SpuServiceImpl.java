package com.cj.shopback.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cj.shopback.model.Spu;
import com.cj.shopback.service.SpuService;
import com.cj.shopback.mapper.SpuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu>
    implements SpuService{
@Autowired
SpuMapper spuMapper;

    @Override
    public List<Spu> getAllSpu() {
        return spuMapper.selectByDto(new Spu());
    }

    @Override
    public IPage<Spu> getPageSpu(Page<Spu> of, Spu spu) {
        return spuMapper.selectPageByDto(of,spu);
    }
}




