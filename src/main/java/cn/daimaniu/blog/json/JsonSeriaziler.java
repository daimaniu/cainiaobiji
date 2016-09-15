package cn.daimaniu.blog.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang.SerializationException;

import java.lang.reflect.Type;


/**
 * Json序列化工具
 * 
 * @see JSON
 * 
 * @author keepcleargas
 */
public class JsonSeriaziler {
	
	private SerializerFeature[] features;
	
	public JsonSeriaziler(){
		this.features = new SerializerFeature[]{};
	}
	
	public JsonSeriaziler(SerializerFeature... features){
		this.features = features;
	}

	/**
	 * java-object as json-string
	 * 
	 * @param object
	 * @return
	 */
	public String seriazileAsString(Object object) {
		if (object == null) {
			return "";
		}
		try {
			return JSON.toJSONString(object, features);
		} catch (Exception ex) {
			throw new SerializationException("Could not write JSON: "
					+ ex.getMessage(), ex);
		}
	}

	/**
	 * json-string to java-object
	 * 
	 * @param jsonString
	 * @return
	 */
	public <T> T deserializeAsObject(String jsonString, Type clazz) {
		if (jsonString == null || clazz == null) {
			return null;
		}
		try {
			return JSON.parseObject(jsonString, clazz);
		} catch (Exception ex) {
			throw new SerializationException("Could not write JSON: "
					+ ex.getMessage(), ex);
		}
	}
}
