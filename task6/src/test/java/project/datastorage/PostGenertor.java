package project.datastorage;

import framework.utils.RandomUtils;
import project.models.Post;

public class PostGenertor {

    public static Post createPostForSend(String postId, String userId, int lengthRandomString) {
        Post post = new Post();
        post.setId(postId);
        post.setUserId(userId);
        post.setTitle(RandomUtils.generateRandomString(lengthRandomString));
        post.setBody(RandomUtils.generateRandomString(lengthRandomString));
        return post;
    }
}
