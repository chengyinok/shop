package com.shop.service;

import com.shop.entity.StoreTag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2020-10-20
 */
public interface StoreTagService extends IService<StoreTag> {

    boolean isUseTag(Set<Long> ids);
}
