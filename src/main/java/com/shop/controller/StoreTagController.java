package com.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.dto.PageDTO;
import com.shop.entity.StoreTag;
import com.shop.exception.BadRequestException;
import com.shop.service.StoreTagService;
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
 * @since 2020-10-20
 */
@RestController
@RequestMapping("/api/tag")
public class StoreTagController {

    @Autowired
    private StoreTagService storeTagService;

    @GetMapping
    public ResponseEntity<Object> list(PageDTO pageDTO, StoreTag storeTag) {
        Page page = new Page(pageDTO.getPage(), pageDTO.getSize());
        QueryWrapper<StoreTag> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(storeTag.getName())) {
            queryWrapper.like("name", storeTag.getName());
        }
        storeTagService.page(page, queryWrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("content", page.getRecords());
        result.put("totalElements", page.getTotal());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody StoreTag storeTag) {
        storeTagService.save(storeTag);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@Validated @RequestBody StoreTag storeTag) {
        storeTagService.updateById(storeTag);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Object> removeByIds(@RequestBody Set<Long> ids) {
        boolean isUse = storeTagService.isUseTag(ids);
        if(!isUse){
            storeTagService.removeByIds(ids);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            throw new BadRequestException("商品标签已被使用无法进行删除操作");
        }


    }
}

