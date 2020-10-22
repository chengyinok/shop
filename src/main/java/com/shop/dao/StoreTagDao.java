package com.shop.dao;

import com.shop.entity.StoreTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

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

    int isUseTag(@Param("ids") Set<Long> ids);
}
