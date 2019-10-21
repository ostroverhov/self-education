package project.steps;

import framework.utils.ApiUtils;
import framework.utils.JsonUtils;
import framework.utils.RandomUtils;
import org.testng.Assert;
import project.models.Post;
import project.models.ResponseFromApi;
import project.models.User;

import java.util.ArrayList;

public class StepsApi {

    private static final String requestForPosts = "https://jsonplaceholder.typicode.com/posts";
    private static final String requestForUsers = "https://jsonplaceholder.typicode.com/users";
    private static final String postIdForSend = "101";
    private static final String userIdForSend = "1";
    private static final int numberTestPost = 99;
    private static final String numberUserTestPost = "10";
    private static final int numberTestPostNonExist = 150;
    private static final int numberTestUser = 5;
    private static final int ok = 200;
    private static final int created = 201;
    private static final int notFound = 404;

    public static void getAllPosts() {
        ResponseFromApi responseFromApi = ApiUtils.getRequest(requestForPosts);
        assertStatusCode(responseFromApi.getStatusCode(), ok);
        assertOrderArrayPosts(JsonUtils.jsonToPostArray(responseFromApi.getBody()));
    }

    public static void getPostByNumber() {
        ResponseFromApi responseFromApi = ApiUtils.getRequest(requestForPosts + "/" + numberTestPost);
        assertStatusCode(responseFromApi.getStatusCode(), ok);
        assertPostByNumber(JsonUtils.jsonToObject(responseFromApi.getBody(), Post.class), String.valueOf(numberTestPost), numberUserTestPost);
    }

    public static void getPostNotExist() {
        ResponseFromApi responseFromApi = ApiUtils.getRequest(requestForPosts + "/" + numberTestPostNonExist);
        assertStatusCode(responseFromApi.getStatusCode(), notFound);
        assertPostIsEmpty(JsonUtils.jsonToObject(responseFromApi.getBody(), Post.class));
    }

    public static void setPost() {
        Post postForSend = createPostForSend(postIdForSend, userIdForSend);
        ResponseFromApi responseFromApi = ApiUtils.sendPost(requestForPosts, JsonUtils.convertToJson(postForSend));
        assertStatusCode(responseFromApi.getStatusCode(), created);
        assertSendPost(postForSend, JsonUtils.jsonToObject(responseFromApi.getBody(), Post.class));
    }

    public static User getAllUsers() {
        ResponseFromApi responseFromApi = ApiUtils.getRequest(requestForUsers);
        assertStatusCode(responseFromApi.getStatusCode(), ok);
        User testUser = JsonUtils.jsonToUsersArray(responseFromApi.getBody()).get(numberTestUser - 1);
        Assert.assertEquals(JsonUtils.readUserFromJson(), testUser, "Users not equals");
        return testUser;
    }

    public static void getUserByNumber(User testUser) {
        ResponseFromApi responseFromApi = ApiUtils.getRequest(requestForUsers + "/" + numberTestUser);
        assertStatusCode(responseFromApi.getStatusCode(), ok);
        Assert.assertEquals(JsonUtils.jsonToObject(responseFromApi.getBody(), User.class), testUser, "Users not equals");
    }

    private static void assertStatusCode(int statusCodeFromResponse, int statusCode) {
        Assert.assertEquals(statusCodeFromResponse, statusCode, "Status code not match");
    }

    private static void assertOrderArrayPosts(ArrayList<Post> posts) {
        for (int i = 0; i < posts.size(); i++) {
            Assert.assertEquals(String.valueOf(i + 1), posts.get(i).getId(), "Post number " + posts.get(i).getId() + " not match");
        }
    }

    private static Post createPostForSend(String postId, String userId) {
        Post post = new Post();
        post.setId(postId);
        post.setUserId(userId);
        post.setTitle(RandomUtils.generateRandomString());
        post.setBody(RandomUtils.generateRandomString());
        return post;
    }

    private static void assertPostByNumber(Post post, String postId, String userId) {
        Assert.assertEquals(post.getId(), postId, "Id post not match");
        Assert.assertEquals(post.getUserId(), userId, "User id not match");
        Assert.assertNotEquals(post.getBody(), "", "Body not empty");
        Assert.assertNotEquals(post.getTitle(), "", "Title not empty");
    }

    private static void assertPostIsEmpty(Post post) {
        Assert.assertNull(post.getId(), "Post id is null");
        Assert.assertNull(post.getUserId(), "User id is null");
        Assert.assertNull(post.getBody(), "Body is null");
        Assert.assertNull(post.getTitle(), "Title is null");
    }

    private static void assertSendPost(Post sendPost, Post getPost) {
        Assert.assertEquals(getPost.getTitle(), sendPost.getTitle(), "Title not match");
        Assert.assertEquals(getPost.getBody(), sendPost.getBody(), "Body not match");
        Assert.assertEquals(getPost.getUserId(), sendPost.getUserId(), "User id not match");
        Assert.assertNotNull(sendPost.getId(), "Post id is present");
    }
}
