package util.mapper;

import models.User;
import util.mapper.BaseMapper;

import java.util.List;

public class UserMapper extends BaseMapper {

    public String mapUserToJson(User user){
        return gsonMapper.mapObjectToJson(user);
    }

    public User mapJsonToUser(String jsonUser){
        return gsonMapper.mapJsonToUser(jsonUser);
    }

    public List<User> mapJsonToListUsers(String json){
        return gsonMapper.mapJsonToListUsers(json);
    }

    public String mapListUserToJson(List<User> users){
        return gsonMapper.mapListUsersToJson(users);
    }
}
