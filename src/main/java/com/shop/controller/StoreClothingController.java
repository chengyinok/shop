package com.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.dto.PageDTO;
import com.shop.entity.StoreClothing;
import com.shop.entity.StoreClothingSize;
import com.shop.entity.StoreClothingTag;
import com.shop.exception.BadRequestException;
import com.shop.service.StoreClothingService;
import com.shop.service.StoreClothingSizeService;
import com.shop.service.StoreClothingTagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

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

    @Autowired
    private StoreClothingTagService storeClothingTagService;

    @Autowired
    private StoreClothingSizeService storeClothingSizeService;

    @GetMapping
    public ResponseEntity<Object> list(PageDTO pageDTO, StoreClothing storeClothing) {
        Page page = new Page(pageDTO.getPage(), pageDTO.getSize());
        List<Map<String, Object>> results = storeClothingService.listPage(page, storeClothing);
        Map<String, Object> result = new HashMap<>();
        for (Map<String, Object> item : results) {
            String sizeId = (String) item.get("sizeIds");
            List<Integer> sizeIds = new ArrayList<>();
            if (StringUtils.isNotBlank(sizeId)) {
                for (String id : sizeId.split(",")) {
                    sizeIds.add(Integer.valueOf(id));
                }
            }
            item.put("sizeIds", sizeIds);
            List<Object> fileList = new ArrayList<>();
            if(item.get("imageUrlI") != null){
                String imageUrlI = (String) item.get("imageUrlI");
                Map<String,Object> file1 = new HashMap<>();
                file1.put("name","imageUrlI");
                file1.put("url",imageUrlI);
                fileList.add(file1);
            }
            if(item.get("imageUrlL") != null){
                String imageUrlL = (String) item.get("imageUrlI");
                Map<String,Object> file1 = new HashMap<>();
                file1.put("name","imageUrlL");
                file1.put("url",imageUrlL);
                fileList.add(file1);
            }
            if(item.get("imageUrlM") != null){
                String imageUrlM = (String) item.get("imageUrlM");
                Map<String,Object> file1 = new HashMap<>();
                file1.put("name","imageUrlM");
                file1.put("url",imageUrlM);
                fileList.add(file1);
            }
            if(item.get("imageUrlR") != null){
                String imageUrlR = (String) item.get("imageUrlR");
                Map<String,Object> file1 = new HashMap<>();
                file1.put("name","imageUrlR");
                file1.put("url",imageUrlR);
                fileList.add(file1);
            }
            if(item.get("imageUrlC") != null){
                String imageUrlC = (String) item.get("imageUrlC");
                Map<String,Object> file1 = new HashMap<>();
                file1.put("name","imageUrlC");
                file1.put("url",imageUrlC);
                fileList.add(file1);
            }

            item.put("fileList", fileList);
        }
        result.put("content", results);
        result.put("totalElements", page.getTotal());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody StoreClothing storeClothing) {
        storeClothing.setDiscount(BigDecimal.ZERO);
        storeClothing.setSales(0);
        storeClothing.setImageUrlI("/api/img/"+storeClothing.getImageUrlI());
        if(StringUtils.isNotBlank(storeClothing.getImageUrlL())){
            storeClothing.setImageUrlL("/api/img/"+storeClothing.getImageUrlL());
        }
        if(StringUtils.isNotBlank(storeClothing.getImageUrlM())){
            storeClothing.setImageUrlM("/api/img/"+storeClothing.getImageUrlM());
        }
        if(StringUtils.isNotBlank(storeClothing.getImageUrlR())){
            storeClothing.setImageUrlR("/api/img/"+storeClothing.getImageUrlR());
        }
        if(StringUtils.isNotBlank(storeClothing.getImageUrlL())){
            storeClothing.setImageUrlL("/api/img/"+storeClothing.getImageUrlL());
        }
        storeClothingService.save(storeClothing);
        if (null != storeClothing.getTagId()) {
            StoreClothingTag storeClothingTag = new StoreClothingTag();
            storeClothingTag.setClothingId(storeClothing.getId());
            storeClothingTag.setTagId(storeClothing.getTagId());
            storeClothingTagService.save(storeClothingTag);
        }

        if(null != storeClothing.getSizeIds()){
            List<StoreClothingSize> storeClothingSizes = new ArrayList<>();
            for (Integer sizeId : storeClothing.getSizeIds()){
                StoreClothingSize storeClothingSize = new StoreClothingSize();
                storeClothingSize.setClothingId(storeClothing.getId());
                storeClothingSize.setSizeId(sizeId);
                storeClothingSizes.add(storeClothingSize);
            }
            if(storeClothingSizes.size()>0){
                storeClothingSizeService.saveBatch(storeClothingSizes);
            }
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@Validated @RequestBody StoreClothing storeClothing) {
        if(!storeClothing.getImageUrlI().startsWith("/api/img")){
            storeClothing.setImageUrlI("/api/img/"+storeClothing.getImageUrlI());
        }
        storeClothingService.updateById(storeClothing);
        if (null != storeClothing.getTagId()) {
            QueryWrapper<StoreClothingTag> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("clothing_id",storeClothing.getId());
            storeClothingTagService.remove(queryWrapper);
            StoreClothingTag storeClothingTag = new StoreClothingTag();
            storeClothingTag.setClothingId(storeClothing.getId());
            storeClothingTag.setTagId(storeClothing.getTagId());
            storeClothingTagService.save(storeClothingTag);
        }

        if(null != storeClothing.getSizeIds()){
            QueryWrapper<StoreClothingSize> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("clothing_id",storeClothing.getId());
            storeClothingSizeService.remove(queryWrapper);
            List<StoreClothingSize> storeClothingSizes = new ArrayList<>();
            for (Integer sizeId : storeClothing.getSizeIds()){
                StoreClothingSize storeClothingSize = new StoreClothingSize();
                storeClothingSize.setClothingId(storeClothing.getId());
                storeClothingSize.setSizeId(sizeId);
                storeClothingSizes.add(storeClothingSize);
            }
            if(storeClothingSizes.size()>0){
                storeClothingSizeService.saveBatch(storeClothingSizes);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Object> removeByIds(@RequestBody Set<Long> ids) {
        QueryWrapper<StoreClothingTag> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("clothing_id",ids);
        storeClothingTagService.remove(queryWrapper);

        QueryWrapper<StoreClothingSize> sizeQueryWrapper = new QueryWrapper<>();
        sizeQueryWrapper.in("clothing_id",ids);
        storeClothingSizeService.remove(sizeQueryWrapper);

        boolean isUse = storeClothingService.isUseClothing(ids);
        if (isUse) {
            throw new BadRequestException("商品已被使用无法进行删除操作");
        } else {
            storeClothingService.removeByIds(ids);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/listBrands")
    public ResponseEntity<Object> listBrands() {
        List<Map<String, Object>> resutls = storeClothingService.listBrands();
        return new ResponseEntity<>(resutls, HttpStatus.OK);
    }

    @GetMapping("/listTags")
    public ResponseEntity<Object> listTags() {
        List<Map<String, Object>> resutls = storeClothingService.listTags();
        return new ResponseEntity<>(resutls, HttpStatus.OK);
    }

    @GetMapping("/listSizes")
    public ResponseEntity<Object> listSizes() {
        List<Map<String, Object>> resutls = storeClothingService.listSizes();
        return new ResponseEntity<>(resutls, HttpStatus.OK);
    }
}

