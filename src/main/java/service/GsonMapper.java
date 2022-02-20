package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.BaseObject;
import models.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonMapper {

    Gson gson = new Gson();

    public String mapObjectToJson(BaseObject baseObject) {
        return gson.toJson(baseObject);
    }

    public User mapJsonToUser(String json) {
        return gson.fromJson(json, User.class);
    }

    public List<User> mapJsonToListUsers(String json){
        Type userListType = new TypeToken <ArrayList<User>> (){}.getType();
        return gson.fromJson(json, userListType);
    }
}
