package models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Comment implements BaseObject{
    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;
}
