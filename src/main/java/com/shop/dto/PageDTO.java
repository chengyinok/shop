package com.shop.dto;

import lombok.Data;

/**
 * Description:
 * User: chengyin
 * Date: 2018-10-22
 */
@Data
public class PageDTO {

    private Integer page = 1;

    private Integer size = 20;

    private String sort;
}
