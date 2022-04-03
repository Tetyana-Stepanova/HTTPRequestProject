package service;

import models.Post;
import util.mapper.PostMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.NoSuchElementException;

public class HttpPostService extends BaseHttpService {

    private static final String POST_URL = "%s/%s/posts";
    private PostMapper postMapper = new PostMapper();

    public List<Post> getAllPostsByUserId(Integer id) throws IOException, InterruptedException {
        String url = String.format(POST_URL, URL, id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json; charset=UTF-8")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return postMapper.mapJsonToListPosts(response.body());
    }

    public Integer getLastPostByUserId(Integer userId) throws IOException, InterruptedException {
        List<Post> posts = getAllPostsByUserId(userId);
        return posts.stream().mapToInt(Post::getId).max().orElseThrow(NoSuchElementException::new);
    }
}
