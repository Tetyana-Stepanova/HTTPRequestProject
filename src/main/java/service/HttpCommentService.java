package service;

import util.WriteToFileUtil;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpCommentService extends BaseHttpService{

    private static final String POST_URL = "https://jsonplaceholder.typicode.com/posts/%s/comments";
    private HttpPostService httpPostService = new HttpPostService();
    private WriteToFileUtil writeToFileUtil = new WriteToFileUtil();

    public String getAllCommentsByPostId(Integer postId) throws IOException, InterruptedException {
        String url = String.format(POST_URL, postId);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json; charset=UTF-8")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public boolean getAndWriteCommentsInFile(Integer userId) throws IOException, InterruptedException {
        Integer lastPostId = httpPostService.getLastPostByUserId(userId);
        String comments = getAllCommentsByPostId(lastPostId);
      return  writeToFileUtil.writeCommentsToFile(userId, lastPostId, comments);
    }
}
