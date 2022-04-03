package util;

import models.Address;
import models.Company;
import models.Geo;
import models.User;

public class SetUpUtile {

    public User createNewUser() {
        User testUser = new User();
        testUser.setName("Tetyana");
        testUser.setEmail("tetyana@gmail.com");
        testUser.setUsername("ST");
        Address testAddress = new Address();
        testAddress.setCity("Kyiv");
        testAddress.setSuite("Dnipr");
        testAddress.setStreet("Bereznyakivska");
        testAddress.setZipcode("098765");
        Geo testGeo = new Geo();
        testGeo.setLat("88.9");
        testGeo.setLng("765.8");
        testAddress.setGeo(testGeo);
        testUser.setAddress(testAddress);
        testUser.setPhone("097654321");
        testUser.setWebsite("sgdhf.com");
        Company testCompany = new Company();
        testCompany.setName("GoIt");
        testCompany.setCatchPhrase(" You can do it");
        testCompany.setBs("aggregate real-time technologies");
        testUser.setCompany(testCompany);
        return testUser;
    }

    public User updateUser(User oldUser){
        oldUser.setUsername("Updated Name");
        return oldUser;
    }
}
