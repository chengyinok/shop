package com.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2020-10-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StoreOrder extends Model<StoreOrder> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 价格
     */
    private BigDecimal sumPrice;

    /**
     * 下单时间
     */
    private LocalDateTime datePublish;

    /**
     * 尺码
     */
    private String size;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 发货状态
     */
    private Integer postStatus;

    /**
     * 服装ID
     */
    private Integer clothingId;

    /**
     * 用户ID
     */
    private Integer userId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
