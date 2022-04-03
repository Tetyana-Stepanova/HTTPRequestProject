package service;

import java.net.http.HttpClient;

public class BaseHttpService {

   protected HttpClient client = HttpClient.newHttpClient();
    protected static final String URL = "https://jsonplaceholder.typicode.com/users";
}
