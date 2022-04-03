package util.mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.*;

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

    public String mapListUsersToJson(List<User> users){
        return gson.toJson(users);
    }

    public List<Post> mapJsonToListPosts(String json){
        Type postListType = new TypeToken <ArrayList<Post>> (){}.getType();
        return gson.fromJson(json, postListType);
    }

    public List<Comment> mapJsonToListComments(String json){
        Type commentListType = new TypeToken <ArrayList<Comment>> (){}.getType();
        return gson.fromJson(json, commentListType);
    }

    public List<UserTodo> mapJsonToListUserTodo(String json){
        Type userTodoListType = new TypeToken <ArrayList<UserTodo>> (){}.getType();
        return gson.fromJson(json, userTodoListType);
    }
}


