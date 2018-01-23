package com.redis;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by zhonghao on 2017/12/27.
 */
public class JsonMapper {
    public JsonMapper() {
    }

    public Map<String, Object> convertToMap(String json) {
        return (Map) JSON.parseObject(json, Map.class);
    }

    public Map<String, Object> convertToMap(Object obj) {
        return this.convertToMap(this.convertToJson(obj));
    }

    public String convertToJson(Object obj) {
        return JSON.toJSONString(obj);
    }

    public List<Map<String, Object>> convertToList(Collection<String> jsons) {
        List<Map<String, Object>> list = new ArrayList();
        Iterator var3 = jsons.iterator();

        while(var3.hasNext()) {
            String json = (String)var3.next();
            if(json != null) {
                list.add(this.convertToMap(json));
            }
        }

        return list;
    }
}