package com.shop.service.impl;

import com.shop.entity.StoreBrand;
import com.shop.dao.StoreBrandDao;
import com.shop.service.StoreBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2020-10-31
 */
@Service
public class StoreBrandServiceImpl extends ServiceImpl<StoreBrandDao, StoreBrand> implements StoreBrandService {

    @Override
    public boolean isUseBrand(Set<Long> ids) {
        int count = this.baseMapper.isUseBrand(ids);
        if (count > 0) {
            return true;
        }
        return false;
    }
}
