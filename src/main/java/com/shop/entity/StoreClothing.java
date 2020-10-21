package com.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-10-20
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class StoreClothing extends Model<StoreClothing> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String name;

    private Double oldPrice;

    private Double newPrice;

    private Double discount;

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


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
