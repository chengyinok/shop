package com.shop.service;

import com.shop.entity.StoreBrand;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2020-10-31
 */
public interface StoreBrandService extends IService<StoreBrand> {

    boolean isUseBrand(Set<Long> ids);
}
