package com.shop.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.StoreClothing;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-10-20
 */
public interface StoreClothingDao extends BaseMapper<StoreClothing> {

    int isUseClothing(@Param("ids") Set<Long> ids);

    List<Map<String, Object>> listPage(Page page,@Param("entity") StoreClothing storeClothing);

    List<Map<String, Object>> listBrands();

    List<Map<String, Object>> listTags();

    List<Map<String, Object>> listSizes();
}
