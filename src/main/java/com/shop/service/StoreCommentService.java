package com.shop.service;

import com.shop.entity.StoreComment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2020-10-31
 */
public interface StoreCommentService extends IService<StoreComment> {

    List<Map<String, Object>> listComment(Integer clothingIdId);
}
