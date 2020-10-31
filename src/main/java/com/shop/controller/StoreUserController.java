package com.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.dto.PageDTO;
import com.shop.entity.StoreUser;
import com.shop.service.StoreUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class StoreUserController {

    @Autowired
    private StoreUserService storeUserService;

    @GetMapping
    public ResponseEntity<Object> list(PageDTO pageDTO, StoreUser storeUser) {
        Page page = new Page(pageDTO.getPage(), pageDTO.getSize());
        QueryWrapper<StoreUser> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(storeUser.getUsername())) {
            queryWrapper.like("username", storeUser.getUsername());
        }
        storeUserService.page(page, queryWrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("content", page.getRecords());
        result.put("totalElements", page.getTotal());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> update(StoreUser storeUser) {
        StoreUser oldStoreUser = storeUserService.getById(storeUser.getId());
        if(oldStoreUser == null){
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        oldStoreUser.setIsActive(storeUser.getIsActive());
        storeUserService.updateById(storeUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

