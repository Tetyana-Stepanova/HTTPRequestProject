package models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Post implements BaseObject{
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
