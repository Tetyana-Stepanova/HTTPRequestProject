package service;

import models.User;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.rmi.NoSuchObjectException;
import java.util.List;

public class HttpService {

    private static final String URL = "https://jsonplaceholder.typicode.com/users";
    private UserMapper userMapper = new UserMapper();

    public User saveUser(User newUser) throws IOException {

        String json = Jsoup
                .connect(URL)
                .data(userMapper.mapUserToMapObject(newUser))
                .ignoreContentType(true)
                .post()
                .body()
                .text();

        return userMapper.mapJsonToUser(json);
    }

    public User updateUser(User newUser) throws IOException {
        User user = getUser(newUser.getId());
        if(user == null) {
            throw new NoSuchObjectException(String.format("User with id %s not found", newUser.getId().toString()));
        }
        String json = Jsoup
                .connect(URL)
                .data(userMapper.mapUserToMapObject(newUser))
                .ignoreContentType(true)
                .post()
                .body()
                .text();

        return userMapper.mapJsonToUser(json);
    }

    public User getUser(Integer userId) throws IOException {
        String getUrl = String.format("%s/%s", URL, userId.toString());
        String json = Jsoup
                .connect(getUrl)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        return userMapper.mapJsonToUser(json);
    }

    public List<User> getUserList() throws IOException {
        String json = Jsoup
                .connect(URL)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        return userMapper.mapJsonToListUsers(json);
    }
}
