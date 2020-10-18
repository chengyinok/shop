package com.shop.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.dto.PageDTO;
import com.shop.entity.StoreOrder;
import com.shop.service.StoreOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
 * @since 2020-10-16
 */
@RestController
@RequestMapping("/api/order")
public class StoreOrderController {

    @Autowired
    private StoreOrderService storeOrderService;

    @GetMapping
    public ResponseEntity<Object> list(PageDTO pageDTO, StoreOrder storeOrder) {
        Page page = new Page(pageDTO.getPage(), pageDTO.getSize());
        List<Map<String, Object>> results = storeOrderService.listPage(page, storeOrder);
        Map<String, Object> result = new HashMap<>();
        result.put("content", results);
        result.put("totalElements", page.getTotal());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody StoreOrder storeOrder) {
        storeOrder.setDatePublish(LocalDateTime.now());
        storeOrder.setPayStatus(0);
        storeOrder.setPostStatus(0);
        storeOrderService.save(storeOrder);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Object> removeById(@RequestBody Set<Long> ids) {
        storeOrderService.removeByIds(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listUsers")
    public ResponseEntity<Object> listUsers(){
        List<Map<String,Object>> resutls = storeOrderService.listUsers();
        return new ResponseEntity<>(resutls,HttpStatus.OK);
    }
    @GetMapping("/listCatagorys")
    public ResponseEntity<Object> listCatagorys(){
        List<Map<String,Object>> resutls = storeOrderService.listCatagorys();
        return new ResponseEntity<>(resutls,HttpStatus.OK);
    }
    @GetMapping("/listClothings")
    public ResponseEntity<Object> listClothings(Integer categoryId){
        List<Map<String,Object>> resutls = storeOrderService.listClothings(categoryId);
        return new ResponseEntity<>(resutls,HttpStatus.OK);
    }
    @GetMapping("/listSizes")
    public ResponseEntity<Object> listSizes(Integer clothingId){
        List<Map<String,Object>> resutls = storeOrderService.listSizes(clothingId);
        return new ResponseEntity<>(resutls,HttpStatus.OK);
    }
    @GetMapping("/getPrice")
    public ResponseEntity<Object> getPrice(Integer clothingId){
        Map<String,Object> resutls = storeOrderService.getPrice(clothingId);
        return new ResponseEntity<>(resutls,HttpStatus.OK);
    }
}

