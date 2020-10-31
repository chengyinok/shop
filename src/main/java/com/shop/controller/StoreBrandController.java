package com.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.dto.PageDTO;
import com.shop.entity.StoreBrand;
import com.shop.exception.BadRequestException;
import com.shop.service.StoreBrandService;
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
 * @since 2020-10-31
 */
@RestController
@RequestMapping("/api/brand")
public class StoreBrandController {

    @Autowired
    private StoreBrandService storeBrandService;

    @GetMapping
    public ResponseEntity<Object> list(PageDTO pageDTO, StoreBrand storeBrand) {
        Page page = new Page(pageDTO.getPage(), pageDTO.getSize());
        QueryWrapper<StoreBrand> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(storeBrand.getName())) {
            queryWrapper.like("name", storeBrand.getName());
        }
        storeBrandService.page(page, queryWrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("content", page.getRecords());
        result.put("totalElements", page.getTotal());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody StoreBrand storeBrand) {
        storeBrandService.save(storeBrand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@Validated @RequestBody StoreBrand storeBrand) {
        storeBrandService.updateById(storeBrand);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Object> removeByIds(@RequestBody Set<Long> ids) {
        boolean isUse = storeBrandService.isUseBrand(ids);
        if (!isUse) {
            storeBrandService.removeByIds(ids);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new BadRequestException("商品品牌已被使用无法进行删除操作");
        }


    }
}

