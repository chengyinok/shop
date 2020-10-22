package com.shop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.StoreClothing;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2020-10-20
 */
public interface StoreClothingService extends IService<StoreClothing> {

    boolean isUseClothing(Set<Long> ids);

    List<Map<String, Object>> listPage(Page page, StoreClothing storeClothing);

    List<Map<String, Object>> listBrands();

    List<Map<String, Object>> listTags();

    List<Map<String, Object>> listSizes();
}
