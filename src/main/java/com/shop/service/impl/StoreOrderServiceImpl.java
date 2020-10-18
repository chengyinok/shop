package com.shop.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.StoreOrder;
import com.shop.dao.StoreOrderDao;
import com.shop.service.StoreOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2020-10-16
 */
@Service
public class StoreOrderServiceImpl extends ServiceImpl<StoreOrderDao, StoreOrder> implements StoreOrderService {

    @Override
    public List<Map<String, Object>> listPage(Page page, StoreOrder storeOrder) {
        return this.baseMapper.listPage(page,storeOrder);
    }

    @Override
    public List<Map<String, Object>> listUsers() {
        return this.baseMapper.listUsers();
    }

    @Override
    public List<Map<String, Object>> listClothings(Integer categoryId) {
        return this.baseMapper.listClothings(categoryId);
    }

    @Override
    public List<Map<String, Object>> listCatagorys() {
        return this.baseMapper.listCatagorys();
    }

    @Override
    public List<Map<String, Object>> listSizes(Integer clothingId) {
        return this.baseMapper.listSizes(clothingId);
    }

    @Override
    public Map<String, Object> getPrice(Integer clothingId) {
        return this.baseMapper.getPrice(clothingId);
    }
}
