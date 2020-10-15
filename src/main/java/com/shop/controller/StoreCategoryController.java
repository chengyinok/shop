package com.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.dto.PageDTO;
import com.shop.entity.StoreCategory;
import com.shop.service.StoreCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/api/category")
public class StoreCategoryController {

    @Autowired
    private StoreCategoryService storeCategoryService;

    @GetMapping
    public ResponseEntity<Object> list(PageDTO pageDTO, StoreCategory storeCategory) {
        Page page = new Page(pageDTO.getPage(), pageDTO.getSize());
        QueryWrapper<StoreCategory> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(storeCategory.getName())) {
            queryWrapper.like("name", storeCategory.getName());
        }
        storeCategoryService.page(page, queryWrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("content", page.getRecords());
        result.put("totalElements", page.getTotal());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody StoreCategory storeCategory) {
        storeCategoryService.save(storeCategory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@Validated @RequestBody StoreCategory storeCategory) {
        storeCategoryService.updateById(storeCategory);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Object> update(@RequestBody Set<Long> ids) {
        storeCategoryService.removeByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

