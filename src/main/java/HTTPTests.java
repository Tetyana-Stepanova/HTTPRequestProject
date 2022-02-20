import models.User;
import service.HttpService;
import service.SetUpUtile;

import java.io.IOException;

public class HTTPTests {
    public static void main(String[] args) throws IOException {
        SetUpUtile setUpUtile = new SetUpUtile();
        User newUser = setUpUtile.createNewUser();
        HttpService httpService = new HttpService();
        User savedUser = httpService.saveUser(newUser);
        System.out.println("savedUser = " + savedUser);
        assert savedUser.getId() != null;
    }
}
