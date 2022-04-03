package util.mapper;

import models.Post;

import java.util.List;

public class PostMapper extends BaseMapper {

    public List<Post> mapJsonToListPosts(String json){
        return gsonMapper.mapJsonToListPosts(json);
    }
}


