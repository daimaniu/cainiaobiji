package cn.daimaniu.blog.json;

import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Author :keepcleargas
 * Date   :2016-09-15 11:56.
 */
public class JsonUtil {
    private static final JsonSeriaziler JSON = new JsonSeriaziler();

    /**
     * 将 对象转换为 Json String
     *
     * @param object
     * @return
     */
    public static String seriazileAsString(Object object) {
        return JSON.seriazileAsString(object);
    }

    /**
     * 将 JsonString 转换为 clazz对象
     *
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T deserializeAsObject(String jsonString, Type clazz) {
        return JSON.deserializeAsObject(jsonString, clazz);
    }

    /**
     * 将 JsonString 解析为 clazz对象数组
     *
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> deserializeAsList(String jsonString, Class clazz) {
        final List<T> jsonResponse = com.alibaba.fastjson.JSON.parseArray(jsonString, clazz);
        return jsonResponse;
    }

    /**
     * 将一个对象，转换成对象
     *
     * @param obj 只能是Object或者Map，不能是数组类型
     * @return
     */
    public static Map<String, Object> toJsonMap(Object obj) {
        if (obj == null)
            return null;
        String objString = com.alibaba.fastjson.JSON.toJSONString(obj);
        return com.alibaba.fastjson.JSON.parseObject(objString, getType());
    }

    private static Type getType() {
        return new TypeReference<Map<String, Object>>() {
        }.getType();
    }
}
