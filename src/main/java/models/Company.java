package models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Company implements  BaseObject{
    private String name;
    private String catchPhrase;
    private String bs;
}
