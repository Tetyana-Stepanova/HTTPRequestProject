package service;

import models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapper {

    GsonMapper gsonMapper = new GsonMapper();
    public Map<String, String> mapUserToMapObject(User user){
        if(user == null){
            return  null;
        }
        Map<String, String> result = new HashMap<>();
        if (user.getId() != null) {
            result.put("id", user.getId().toString());
        }

        result.put("name", user.getName() != null ? user.getName() : "");
        result.put("username", user.getUsername() != null ? user.getUsername() : "");
        result.put("email", user.getEmail() !=null ? user.getEmail() : "");
        result.put("address", gsonMapper.mapObjectToJson(user.getAddress()));
        result.put("phone", user.getPhone() != null ? user.getPhone() : "");
        result.put("website", user.getWebsite() !=null ? user.getWebsite() : "");
        result.put("company", gsonMapper.mapObjectToJson(user.getCompany()));
        return result;
    }

    public User mapJsonToUser(String jsonUser){
        return gsonMapper.mapJsonToUser(jsonUser);
    }

    public List<User> mapJsonToListUsers(String json){
        return gsonMapper.mapJsonToListUsers(json);
    }
}
