package com.shop.dao;

import com.shop.entity.StoreBrand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-10-31
 */
public interface StoreBrandDao extends BaseMapper<StoreBrand> {

    int isUseBrand(@Param("ids") Set<Long> ids);
}
