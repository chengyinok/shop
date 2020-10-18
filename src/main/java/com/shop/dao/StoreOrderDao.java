package com.shop.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.StoreOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-10-16
 */
public interface StoreOrderDao extends BaseMapper<StoreOrder> {

    List<Map<String, Object>> listPage(Page page,@Param("entity") StoreOrder storeOrder);

    List<Map<String, Object>> listSizes(Integer clothingId);

    List<Map<String, Object>> listCatagorys();

    List<Map<String, Object>> listClothings(Integer categoryId);

    List<Map<String, Object>> listUsers();

    Map<String, Object> getPrice(Integer clothingId);
}
