package service;

import models.User;
import util.mapper.UserMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.rmi.NoSuchObjectException;
import java.util.List;

public class HttpUserService extends BaseHttpService {

    private UserMapper userMapper = new UserMapper();

    public User createUser(User newUser) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(userMapper.mapUserToJson(newUser)))
                .build();
        HttpResponse<String> response = null;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return userMapper.mapJsonToUser(response.body());
    }

    public User updateUser(User newUser) throws IOException, InterruptedException {
        User user = getUserById(newUser.getId());
        if(user == null) {
            throw new NoSuchObjectException(String.format("User with id %s not found", newUser.getId().toString()));
        }
        String updateUrl = String.format("%s/%s",URL, newUser.getId());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(updateUrl))
                .header("Content-Type", "application/json; charset=UTF-8")
                .PUT(HttpRequest.BodyPublishers.ofString(userMapper.mapUserToJson(newUser)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return userMapper.mapJsonToUser(response.body());
    }

    public User getUserById(Integer userId) throws IOException, InterruptedException {
        String getUrl = String.format("%s/%s", URL, userId.toString());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getUrl))
                .header("Content-Type", "application/json; charset=UTF-8")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return userMapper.mapJsonToUser(response.body());
    }

    public List<User> getAllUsers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "application/json; charset=UTF-8")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return userMapper.mapJsonToListUsers(response.body());
    }

    public int deleteUserById(Integer userId) throws IOException, InterruptedException {
        String getUrl = String.format("%s/%s", URL, userId.toString());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getUrl))
                .header("Content-Type", "application/json; charset=UTF-8")
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.statusCode();
    }

    public List<User> getUserByName(String userName) throws IOException, InterruptedException {
        String getUrl = String.format("%s?username=%s", URL, userName);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getUrl))
                .header("Content-Type", "application/json; charset=UTF-8")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return userMapper.mapJsonToListUsers(response.body());
    }
}
