package com.cj.shopback;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.shopback.mapper.SkuMapper;
import com.cj.shopback.mapper.SpecParamMapper;
import com.cj.shopback.mapper.SpuMapper;
import com.cj.shopback.model.Sku;
import com.cj.shopback.model.SpecParam;
import com.cj.shopback.model.Spu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class ShopBackApplicationTests {

    @Autowired
    SpuMapper spuMapper;
    @Test
    void contextLoads() {
        Spu spu = new Spu();
//        spu.setTitle("小米9");
        Page<Spu> page = Page.of(1, 2);
//        IPage<Spu> pageList = spuMapper.selectPageByDto(page, null);
//        System.out.println("pageList = " + pageList);
        List<Spu> spus = spuMapper.selectByDto(spu);
       spus.forEach(System.out::println);
    }

    @Test
    public void test02(){
        Spu spu = new Spu();
        Page<Spu> page = Page.of(1, 2);
        IPage<Spu> spuIPage = spuMapper.selectPageByDto(page, spu);
        System.out.println("spuIPage = " + spuIPage);
        List<Spu> records = spuIPage.getRecords();
        records.forEach(System.out::println);
        System.out.println(spuIPage.getSize());
        System.out.println(spuIPage.getCurrent());
    }

    @Autowired
    SkuMapper skuMapper;

    @Test
    public void test03(){
        Sku sku = new Sku();
        HashMap<String, List> map = new HashMap<>();
        map.put("desc", Arrays.asList("111.jpg","222.jpg"));
        sku.setImages(map);
        sku.setTitle("111");
        sku.setPrice(BigDecimal.valueOf(2999));
        sku.setParam(map);
        sku.setValid(true);
        int insert = skuMapper.insert(sku);
        System.out.println("insert = " + insert);
    }

}
