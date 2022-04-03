import models.User;
import models.UserTodo;
import service.HttpCommentService;
import service.HttpUserService;
import service.HttpUserToDoService;
import util.SetUpUtile;

import java.io.IOException;
import java.util.List;

public class HTTPTests {
    public static void main(String[] args) throws IOException, InterruptedException {
        SetUpUtile setUpUtile = new SetUpUtile();
        HttpUserService httpUserService = new HttpUserService();

        User newUser = setUpUtile.createNewUser();
        User savedUser = httpUserService.createUser(newUser);
        System.out.println("Create result savedUser = " + savedUser);
        assert savedUser.getId() != null;

        User existedUser = httpUserService.getUserById(1);
        System.out.println("Get result existedUser = " + existedUser);
        assert existedUser.getName() != null;

        User updatedUser = httpUserService.updateUser(setUpUtile.updateUser(existedUser));
        System.out.println("Update result updatedUser = " + updatedUser);
        assert updatedUser.getName().equals("Updated Name");

        int requestStatus = httpUserService.deleteUserById(11);
        System.out.println("Delete status: " + requestStatus);
        assert String.valueOf(requestStatus).startsWith("2");

        List<User> allUsers = httpUserService.getAllUsers();
        System.out.println("allUsers:");
        allUsers.forEach(System.out::println);
        assert !allUsers.isEmpty();

        List<User> usersByName = httpUserService.getUserByName("Antonette");
        System.out.println("GetUserByName userByName = " + usersByName);
        assert usersByName.get(0).getId() != null;

        //Write comments in file
        HttpCommentService httpCommentService = new HttpCommentService();
        boolean isWrittenFile = httpCommentService.getAndWriteCommentsInFile(1);
        assert isWrittenFile;

        //Get uncompleted todos
        HttpUserToDoService httpUserToDoService = new HttpUserToDoService();
        List<UserTodo> userTodos = httpUserToDoService.getNotCompletedUserToDo(2);
        System.out.println("Uncompleted userTodos: ");
        userTodos.forEach(System.out::println);
        assert !userTodos.isEmpty();
    }
}
