package com.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.dto.PageDTO;
import com.shop.entity.StoreClothing;
import com.shop.exception.BadRequestException;
import com.shop.service.StoreClothingService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author
 * @since 2020-10-20
 */
@RestController
@RequestMapping("/api/clothing")
public class StoreClothingController {

    @Autowired
    private StoreClothingService storeClothingService;

    @GetMapping
    public ResponseEntity<Object> list(PageDTO pageDTO, StoreClothing storeClothing) {
        Page page = new Page(pageDTO.getPage(), pageDTO.getSize());
        List<Map<String,Object>> results= storeClothingService.listPage(page,storeClothing);
        Map<String, Object> result = new HashMap<>();
        result.put("content", results);
        result.put("totalElements", page.getTotal());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody StoreClothing storeClothing) {
        storeClothingService.save(storeClothing);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@Validated @RequestBody StoreClothing storeClothing) {
        storeClothingService.updateById(storeClothing);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Object> removeByIds(@RequestBody Set<Long> ids) {
        boolean isUse = storeClothingService.isUseClothing(ids);
        if(isUse){
            throw new BadRequestException("商品已被使用无法进行删除操作");
        }else{
            storeClothingService.removeByIds(ids);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/listBrands")
    public ResponseEntity<Object> listBrands(){
        List<Map<String,Object>> resutls = storeClothingService.listBrands();
        return new ResponseEntity<>(resutls,HttpStatus.OK);
    }

    @GetMapping("/listTags")
    public ResponseEntity<Object> listTags(){
        List<Map<String,Object>> resutls = storeClothingService.listTags();
        return new ResponseEntity<>(resutls,HttpStatus.OK);
    }

    @GetMapping("/listSizes")
    public ResponseEntity<Object> listSizes(){
        List<Map<String,Object>> resutls = storeClothingService.listSizes();
        return new ResponseEntity<>(resutls,HttpStatus.OK);
    }
}

