package com.cj.shopback.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.shopback.model.Spu;
import com.cj.shopback.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author：waterkid
 * @Date：2023/3/16 14:40
 */
@RestController
@RequestMapping("/spu")
@CrossOrigin(value = "*")
public class SpuController {
    @Autowired
    SpuService spuService;



    @GetMapping
    public List<Spu> getAllSpu(){
        return spuService.getAllSpu();
    }

    @GetMapping("/getByPage")
    public IPage<Spu> getSpuByPage(@RequestParam(required = false,defaultValue = "1") Integer currentPage,
                                   @RequestParam(required = false,defaultValue = "3") Integer pageSize,
                                   @RequestParam(required = false) String title){
        System.out.println("title = " + title);
        System.out.println("currentPage = " + currentPage);
        System.out.println("pageSize = " + pageSize);
        Spu spu = new Spu();
        if (title !=null && !title.trim().equals("")){
            spu.setTitle(title);
        }

        return spuService.getPageSpu(Page.of(currentPage,pageSize),spu);
    }
}
