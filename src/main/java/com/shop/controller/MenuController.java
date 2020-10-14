package com.shop.controller;

import com.shop.vo.MenuMetaVo;
import com.shop.vo.MenuVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @GetMapping(value = "/build")
    public ResponseEntity<Object> buildMenus() {
        List<MenuVo> menus = new LinkedList<>();
        MenuVo menuVo = new MenuVo();
        menuVo.setAlwaysShow(true);
        menuVo.setComponent("Layout");
        menuVo.setHidden(false);
        menuVo.setName("功能菜单");
        menuVo.setPath("/system");
        menuVo.setRedirect("noredirect");
        MenuMetaVo metaVo = new MenuMetaVo("功能菜单", "system", true);
        menuVo.setMeta(metaVo);
        List<MenuVo> menuChildrens = new ArrayList<>();

        MenuVo userMenu = new MenuVo();
        userMenu.setName("User");
        userMenu.setPath("user");
        userMenu.setHidden(false);
        userMenu.setComponent("system/user/index");
        MenuMetaVo userMeta = new MenuMetaVo("用户管理", "peoples", true);
        userMenu.setMeta(userMeta);
        menuChildrens.add(userMenu);

        MenuVo catagoryMenu = new MenuVo();
        catagoryMenu.setName("Catagory");
        catagoryMenu.setPath("catagory");
        catagoryMenu.setHidden(false);
        catagoryMenu.setComponent("system/catagory/index");
        MenuMetaVo catagoryMeta = new MenuMetaVo("分类管理", "dictionary", true);
        catagoryMenu.setMeta(catagoryMeta);
        menuChildrens.add(catagoryMenu);

        MenuVo orderMenu = new MenuVo();
        orderMenu.setName("Order");
        orderMenu.setPath("order");
        orderMenu.setHidden(false);
        orderMenu.setComponent("system/order/index");
        MenuMetaVo orderMeta = new MenuMetaVo("订单管理", "menu", true);
        orderMenu.setMeta(orderMeta);
        menuChildrens.add(orderMenu);
        menuVo.setChildren(menuChildrens);
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }
}
