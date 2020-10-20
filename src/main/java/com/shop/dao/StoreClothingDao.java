package com.shop.dao;

import com.shop.entity.StoreClothing;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

    int isUseClothing(Set<Long> ids);
}
