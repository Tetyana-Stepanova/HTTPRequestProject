package service;

import models.Address;
import models.Company;
import models.User;

public class SetUpUtile {

    public User createNewUser() {
        User testUser = new User();
        testUser.setName("Tetyana");
        testUser.setEmail("tetyana@gmail.com");
        testUser.setUsername("ST");
        Address testAddress = new Address();
        testAddress.setCity("Kyiv");
        testUser.setAddress(testAddress);
        Company testCompany = new Company();
        testCompany.setName("GoIt");
        testUser.setCompany(testCompany);
        return testUser;
    }
}
