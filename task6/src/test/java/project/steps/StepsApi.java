package project.steps;

import com.google.gson.reflect.TypeToken;
import framework.utils.JsonPlaceholderApi;
import framework.utils.JsonUtils;
import org.testng.Assert;
import project.datastorage.PostGenertor;
import project.models.Post;
import project.models.ResponseFromApi;
import project.models.User;

import java.util.ArrayList;
import java.util.List;

public class StepsApi {

    private static final String pathToTestUser = "src/test/resources/testUser.json";
    private static final int lengthRandomString = 10;
    private static final String postIdForSend = "101";
    private static final String userIdForSend = "1";
    private static final int numberTestPost = 99;
    private static final String numberUserTestPost = "10";
    private static final int numberTestPostNonExist = 150;
    private static final int numberTestUser = 5;
    private static final int ok = 200;
    private static final int created = 201;
    private static final int notFound = 404;

    public static void getAllPosts() throws Throwable {
        ResponseFromApi responseFromApi = JsonPlaceholderApi.getAllPosts();
        assertStatusCode(responseFromApi, ok);
        assertOrderArrayPosts(JsonUtils.jsonToArray(responseFromApi.getBody(), new TypeToken<List<Post>>() {
        }.getType()));
    }

    public static void getPostByNumber() throws Throwable {
        ResponseFromApi responseFromApi = JsonPlaceholderApi.getPostByNumber(numberTestPost);
        assertStatusCode(responseFromApi, ok);
        assertPostByNumber(JsonUtils.jsonToObject(responseFromApi.getBody(), Post.class), String.valueOf(numberTestPost), numberUserTestPost);
    }

    public static void getPostNotExist() throws Throwable {
        ResponseFromApi responseFromApi = JsonPlaceholderApi.getPostByNumber(numberTestPostNonExist);
        assertStatusCode(responseFromApi, notFound);
        assertPostIsEmpty(JsonUtils.jsonToObject(responseFromApi.getBody(), Post.class));
    }

    public static void setPost() throws Throwable {
        Post postForSend = PostGenertor.createPostForSend(postIdForSend, userIdForSend, lengthRandomString);
        ResponseFromApi responseFromApi = JsonPlaceholderApi.setPost(JsonUtils.convertToJson(postForSend));
        assertStatusCode(responseFromApi, created);
        assertSendPost(postForSend, JsonUtils.jsonToObject(responseFromApi.getBody(), Post.class));
    }

    public static User getAllUsers() throws Throwable {
        ResponseFromApi responseFromApi = JsonPlaceholderApi.getAllUsers();
        assertStatusCode(responseFromApi, ok);
        User testUser = (User) JsonUtils.jsonToArray(responseFromApi.getBody(), new TypeToken<List<User>>() {
        }.getType()).get(numberTestUser - 1);
        Assert.assertEquals(JsonUtils.readObjectFromJson(User.class, pathToTestUser), testUser, "Users not equals");
        return testUser;
    }

    public static void getUserByNumber(User testUser) throws Throwable {
        ResponseFromApi responseFromApi = JsonPlaceholderApi.getUserByNumber(numberTestUser);
        assertStatusCode(responseFromApi, ok);
        Assert.assertEquals(JsonUtils.jsonToObject(responseFromApi.getBody(), User.class), testUser, "Users not equals");
    }

    private static void assertStatusCode(ResponseFromApi responseFromApi, int statusCode) {
        Assert.assertEquals(responseFromApi.getStatusCode(), statusCode, "Status code not match");
    }

    private static void assertOrderArrayPosts(ArrayList<Post> posts) {
        for (int i = 0; i < posts.size() - 1; i++) {
            int idPostFromArray = getIdPostFromArray(posts, i);
            Assert.assertTrue(getIdPostFromArray(posts, i + 1) > idPostFromArray, String.format("Post number %s not match", idPostFromArray));
        }
    }

    private static int getIdPostFromArray(ArrayList<Post> posts, int numberPost) {
        return Integer.parseInt(posts.get(numberPost).getId());
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
