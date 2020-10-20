package com.shop.service;

import com.shop.entity.StoreClothing;
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
public interface StoreClothingService extends IService<StoreClothing> {

    boolean isUseClothing(Set<Long> ids);
}
