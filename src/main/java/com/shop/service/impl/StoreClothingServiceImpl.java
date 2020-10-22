package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.StoreClothing;
import com.shop.dao.StoreClothingDao;
import com.shop.service.StoreClothingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
    public List<Map<String, Object>> listPage(Page page, StoreClothing storeClothing) {
        return this.baseMapper.listPage(page,storeClothing);
    }

    @Override
    public boolean isUseClothing(Set<Long> ids) {
        int count = this.baseMapper.isUseClothing(ids);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Map<String, Object>> listBrands() {
        return this.baseMapper.listBrands();
    }

    @Override
    public List<Map<String, Object>> listTags() {
        return this.baseMapper.listTags();
    }

    @Override
    public List<Map<String, Object>> listSizes() {
        return this.baseMapper.listSizes();
    }
}
