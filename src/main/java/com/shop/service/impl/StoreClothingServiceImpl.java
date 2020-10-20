package com.shop.service.impl;

import com.shop.entity.StoreClothing;
import com.shop.dao.StoreClothingDao;
import com.shop.service.StoreClothingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2020-10-20
 */
@Service
public class StoreClothingServiceImpl extends ServiceImpl<StoreClothingDao, StoreClothing> implements StoreClothingService {

    @Override
    public boolean isUseClothing(Set<Long> ids) {
        int count = this.baseMapper.isUseClothing(ids);
        if (count > 0) {
            return true;
        }
        return false;
    }
}
