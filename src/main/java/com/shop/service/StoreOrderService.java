package com.shop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.StoreOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2020-10-16
 */
public interface StoreOrderService extends IService<StoreOrder> {

    List<Map<String, Object>> listPage(Page page, StoreOrder storeOrder);

    List<Map<String, Object>> listUsers();

    List<Map<String, Object>> listClothings(Integer categoryId);

    List<Map<String, Object>> listCatagorys();

    List<Map<String, Object>> listSizes(Integer clothingId);

    Map<String, Object> getPrice(Integer clothingId);
}
