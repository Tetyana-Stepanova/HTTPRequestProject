package service;

import models.Post;
import models.UserTodo;
import util.mapper.ToDoMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class HttpUserToDoService extends BaseHttpService{
    private static final String URL_TODOS = "%s/%s/todos";
    private ToDoMapper toDoMapper = new ToDoMapper();

    public List<UserTodo> getAllUserTodoByUserId(Integer userId) throws IOException, InterruptedException {
        String url = String.format(URL_TODOS, URL, userId);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json; charset=UTF-8")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return toDoMapper.mapJsonToListUserTodo(response.body());
    }

    public List<UserTodo> getNotCompletedUserToDo(Integer userId) throws IOException, InterruptedException {
        return getAllUserTodoByUserId(userId).stream()
                .filter(userTodo -> !userTodo.isCompleted())
                .collect(Collectors.toList());
    }
}
