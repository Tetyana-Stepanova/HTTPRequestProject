package models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Address implements BaseObject{
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

}
