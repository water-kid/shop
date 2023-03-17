package com.cj.shopback.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.shopback.mapper.SkuMapper;
import com.cj.shopback.mapper.SpecParamMapper;
import com.cj.shopback.model.RespBean;
import com.cj.shopback.model.Sku;
import com.cj.shopback.model.SpecParam;
import com.cj.shopback.service.SkuService;
import com.cj.shopback.service.SpecParamService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author：waterkid
 * @Date：2023/3/16 11:19
 */
@RestController
@RequestMapping("/sku")
@CrossOrigin(value = "*")
public class SkuController {

    private SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
    @Autowired
    SkuService skuService;

    @Autowired
    SpecParamService specParamService;

    @GetMapping("")
    public IPage<Sku> getPageSku(@RequestParam(required = false,defaultValue = "1") Integer currentPage,
                                 @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false) String title){
        System.out.println("title = " + title);
        Sku sku = new Sku();
        if (title !=null && !title.trim().equals("")){
            sku.setTitle(title);
        }
        return skuService.getPageSku(Page.of(currentPage,pageSize),sku);
    }

    @GetMapping("/{id}")
    public IPage<Sku> getPageSku(@RequestParam(required = false,defaultValue = "1") Integer currentPage,
                                 @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false) String title,
                                 @PathVariable("id") Integer id){
        System.out.println("title = " + title);
        Sku sku = new Sku();
        if (title !=null && !title.trim().equals("")){
            sku.setTitle(title);
        }
        if (id !=null){
            sku.setSpuId(id);
        }

        return skuService.getPageSku(Page.of(currentPage,pageSize),sku);
    }

    @PostMapping("/upload")
    public RespBean uploadImg(MultipartFile[] multipartFiles, HttpServletRequest request){

        if (multipartFiles != null && multipartFiles.length>0){
            String formatData = sdf.format(new Date()); //  /yyyy/MM/dd/
            // 获取服务器文件资源真实地址
            String realPath = request.getServletContext().getRealPath("/img")+formatData;
            System.out.println("realPath = " + realPath);

            File dir = new File(realPath);
            if (!dir.exists()){
                dir.mkdirs();
            }

            ArrayList<String> imageList = new ArrayList<>();
            for (MultipartFile file : multipartFiles) {
                String oldName = file.getOriginalFilename();
                String newName = UUID.randomUUID().toString().replace("-","")+oldName.substring(oldName.indexOf("."));

                try {
                    // 存储文件
                    File file1 = new File(dir, newName);
                    file.transferTo(file1);
                    String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/img"+formatData+newName;
                    imageList.add(url);
                } catch (IOException e) {
                    e.printStackTrace();
                    return RespBean.error("上传文件错误");
                }


            }

            HashMap<String, List<String>> map = new HashMap<>();
            map.put("desc",imageList);
            return RespBean.ok("上传成功",map);
        }
        return RespBean.error("上传文件为空");
    }


    /**
     *
     * @param id  spu_id
     * @return
     */
    @GetMapping("/params/{id}")
    public List<SpecParam> getParamsBySpuId(@PathVariable("id") Integer id){
        return specParamService.getParamsBySpuId(id);
    }

    @Autowired
    SkuMapper skuMapper;

    @PostMapping
    public RespBean addSku(@RequestBody Sku sku) throws JsonProcessingException {
        System.out.println("sku = " + sku);
        sku.setParam(new ObjectMapper().writeValueAsString(sku.getParam()));
        sku.setImages(new ObjectMapper().writeValueAsString(sku.getImages()));
        if (skuMapper.insert(sku)==1){
            return  RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }


    @PutMapping
    public RespBean updateSku(@RequestBody Sku sku) throws JsonProcessingException {
        System.out.println("sku = " + sku);
        sku.setParam(new ObjectMapper().writeValueAsString(sku.getParam()));
        sku.setImages(new ObjectMapper().writeValueAsString(sku.getImages()));
        if (skuMapper.updateById(sku)==1){
            return  RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSku(@PathVariable("id") Integer id) throws JsonProcessingException {

        Sku sku = new Sku();
        sku.setId(id);
        int row = skuMapper.deleteById(sku);
        if (row==1){
            return  RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }


    @DeleteMapping("/batchDelete")
    public RespBean batchDeleteSku(Integer[] ids)  {


        boolean b = skuService.batchDeleteByIds(Arrays.asList(ids));

        if (b){
            return  RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
