package com.shop.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 chengyin
 * @创建时间 2018/7/25
 * @描述
 */
@Getter
@Setter
public class JsonData {

    private boolean ret;

    private Integer code;

    private String msg;

    private Object data;

    public JsonData(boolean ret) {
        this.ret = ret;
    }

    public static JsonData success() {
        JsonData jsonData = new JsonData(true);
        return jsonData;
    }

    public static JsonData success(Object object) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        jsonData.code = 0;
        return jsonData;
    }

    public static JsonData success(Object object, String msg) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        jsonData.code = 0;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData fail(String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        jsonData.code = 1;
        return jsonData;
    }

    public Map<String,Object> toMap(){
        HashMap<String,Object> result = new HashMap<>();
        result.put("ret",ret);
        result.put("msg",msg);
        result.put("code",code);
        result.put("data",data);
        return result;
    }

}
