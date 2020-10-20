package com.shop.dao;

import com.shop.entity.StoreTag;
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
public interface StoreTagDao extends BaseMapper<StoreTag> {

    int isUseTag(Set<Long> ids);
}
