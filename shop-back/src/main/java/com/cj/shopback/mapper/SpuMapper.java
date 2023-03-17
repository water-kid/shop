package com.cj.shopback.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cj.shopback.model.Spu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity com.cj.shopback.model.Spu
 */
public interface SpuMapper extends BaseMapper<Spu> {
    List<Spu> selectByDto(@Param("spu") Spu spu);

    IPage<Spu> selectPageByDto(IPage<Spu> page,@Param("spu") Spu spu);
}




