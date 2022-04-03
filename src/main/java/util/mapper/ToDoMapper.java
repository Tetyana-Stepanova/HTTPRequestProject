package util.mapper;

import models.UserTodo;

import java.util.List;

public class ToDoMapper extends BaseMapper{

    public List<UserTodo> mapJsonToListUserTodo(String json){
        return gsonMapper.mapJsonToListUserTodo(json);
    }
}
