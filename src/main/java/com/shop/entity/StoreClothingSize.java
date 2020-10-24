package com.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2020-10-24
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class StoreClothingSize extends Model<StoreClothingSize> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private Integer clothingId;

    private Integer sizeId;


    @Override
    protected Serializable pkVal() {
          return this.id;
      }

}
