package com.shop.service.impl;

import com.shop.entity.StoreComment;
import com.shop.dao.StoreCommentDao;
import com.shop.service.StoreCommentService;
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
 * @since 2020-10-31
 */
@Service
public class StoreCommentServiceImpl extends ServiceImpl<StoreCommentDao, StoreComment> implements StoreCommentService {

    @Override
    public List<Map<String, Object>> listComment(Integer clothingIdId) {
        return this.baseMapper.listComment(clothingIdId);
    }
}
