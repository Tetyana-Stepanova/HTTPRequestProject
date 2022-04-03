package models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User implements BaseObject{
    private Integer id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
}


