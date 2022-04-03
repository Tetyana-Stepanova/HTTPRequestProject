package models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserTodo {

    private Integer userId;
    private Integer id;
    private String title;
    private boolean completed;
}
