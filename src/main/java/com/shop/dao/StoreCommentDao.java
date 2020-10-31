package com.shop.dao;

import com.shop.entity.StoreComment;
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
 * @since 2020-10-31
 */
public interface StoreCommentDao extends BaseMapper<StoreComment> {

    List<Map<String, Object>> listComment(@Param("clothingIdId") Integer clothingIdId);
}
