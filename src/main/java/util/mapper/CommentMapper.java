package util.mapper;

import models.Comment;
import util.mapper.BaseMapper;

import java.util.List;

public class CommentMapper extends BaseMapper {
    public List<Comment> mapJsonToListComments(String json){
        return gsonMapper.mapJsonToListComments(json);
    }
}
