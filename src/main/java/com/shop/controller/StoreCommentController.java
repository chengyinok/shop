package com.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shop.entity.StoreComment;
import com.shop.service.StoreCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author
 * @since 2020-10-31
 */
@RestController
@RequestMapping("/api/comment")
public class StoreCommentController {

    @Autowired
    private StoreCommentService storeCommentService;

    @GetMapping
    public ResponseEntity<Object> list(Integer clothingIdId) {
        List<Map<String,Object>> results = storeCommentService.listComment(clothingIdId);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

}

