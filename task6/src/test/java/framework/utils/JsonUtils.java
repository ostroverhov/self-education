package framework.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import project.models.Post;
import project.models.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String pathToTestUser = "src/test/resources/testUser.json";

    public static User readUserFromJson() {
        User user = null;
        try {
            user = new Gson().fromJson(new FileReader(pathToTestUser), User.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static String convertToJson(Object object) {
        return new Gson().toJson(object, object.getClass());
    }

    public static ArrayList<Post> jsonToPostArray(String bodyResponse) {
        Type itemsListType = new TypeToken<List<Post>>() {
        }.getType();
        return new Gson().fromJson(bodyResponse, itemsListType);
    }

    public static ArrayList<User> jsonToUsersArray(String bodyResponse) {
        Type itemsListType = new TypeToken<List<User>>() {
        }.getType();
        return new Gson().fromJson(bodyResponse, itemsListType);
    }

    public static <T> T jsonToObject(String bodyResponse, Class<T> clazz) {
        return new Gson().fromJson(bodyResponse, clazz);
    }
}
