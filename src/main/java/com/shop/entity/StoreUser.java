package com.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StoreUser extends Model<StoreUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String password;

    private Date lastLogin;

    private Boolean isSuperuser;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean isStaff;

    private Boolean isActive;

    private Date dateJoined;

    private String qq;

    private String mobile;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
