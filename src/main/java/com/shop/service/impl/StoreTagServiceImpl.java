package com.shop.service.impl;

import com.shop.entity.StoreTag;
import com.shop.dao.StoreTagDao;
import com.shop.service.StoreTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author
 * @since 2020-10-20
 */
@Service
public class StoreTagServiceImpl extends ServiceImpl<StoreTagDao, StoreTag> implements StoreTagService {

    @Override
    public boolean isUseTag(Set<Long> ids) {
        int count = this.baseMapper.isUseTag(ids);
        if (count > 0) {
            return true;
        }
        return false;
    }
}
