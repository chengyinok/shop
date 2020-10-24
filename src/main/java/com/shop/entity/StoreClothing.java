package com.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2020-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StoreClothing extends Model<StoreClothing> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private BigDecimal oldPrice;

    private BigDecimal newPrice;

    private BigDecimal discount;

    @TableField(value = "`desc`")
    private String desc;

    private Integer sales;

    private Integer num;

    private String imageUrlI;

    private String imageUrlL;

    private String imageUrlM;

    private String imageUrlR;

    private String imageUrlC;

    private Integer brandId;

    private Integer categoryId;

    private transient Integer tagId;

    private transient List<Integer> sizeIds;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
