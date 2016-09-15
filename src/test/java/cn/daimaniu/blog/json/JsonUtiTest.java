package cn.daimaniu.blog.json;

import cn.daimaniu.blog.json.model.UserModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Author :keepcleargas
 * Date   :2016-09-15 12:07.
 */
public class JsonUtiTest {
    @Test
    public void testJsonObject() {
        UserModel userModel = new UserModel();
        userModel.setFirstName("chen");
        userModel.setLastName("billy");
        userModel.setEmail("wsncqs@gmail.com");

        String jsonStr = JsonUtil.seriazileAsString(userModel);
        System.out.println("jsonStr:" + jsonStr);

        //jsonStr -> object
        UserModel deUserModel = JsonUtil.deserializeAsObject(jsonStr, UserModel.class);

        assertEquals(userModel.getEmail(), deUserModel.getEmail());
    }

    @Test
    public void testJsonArray() {
        List<UserModel> userModels = new ArrayList<>();

        UserModel userModel = new UserModel();
        userModel.setFirstName("chen");
        userModel.setLastName("billy");
        userModel.setEmail("wsncqs@gmail.com");

        userModels.add(userModel);

        UserModel userModel1 = new UserModel();
        userModel1.setFirstName("chen");
        userModel1.setLastName("billy");
        userModel1.setEmail("wsncqs@hotmail.com");

        userModels.add(userModel1);

        String jsonStr = JsonUtil.seriazileAsString(userModels);
        System.out.println("jsonStr:" + jsonStr);

        //jsonstr ->array
        List<UserModel> deUserModels = JsonUtil.deserializeAsList(jsonStr, UserModel.class);

        assertEquals(2, deUserModels.size());
        assertEquals(userModel.getEmail(), deUserModels.get(0).getEmail());
    }
}
