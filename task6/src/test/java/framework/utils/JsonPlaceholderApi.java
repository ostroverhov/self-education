package framework.utils;

import aquality.selenium.logger.Logger;
import project.models.ResponseFromApi;

public class JsonPlaceholderApi {

    private static final Logger logger = Logger.getInstance();
    private static final String requestForPosts = "posts";
    private static final String requestForUsers = "users";

    public static ResponseFromApi getAllPosts() throws Throwable {
        logger.info("Get all posts");
        return ApiUtils.sendGet(createStringRequest(requestForPosts));
    }

    public static ResponseFromApi getPostByNumber(int number) throws Throwable {
        logger.info("Get post by number " + number);
        return ApiUtils.sendGet(createStringRequest(requestForPosts, number));
    }

    public static ResponseFromApi setPost(String jsonString) throws Throwable {
        logger.info("Set new post");
        return ApiUtils.sendPost(createStringRequest(requestForPosts), jsonString);
    }

    public static ResponseFromApi getAllUsers() throws Throwable {
        logger.info("Get all users");
        return ApiUtils.sendGet(createStringRequest(requestForUsers));
    }

    public static ResponseFromApi getUserByNumber(int number) throws Throwable {
        logger.info("Get user by number " + number);
        return ApiUtils.sendGet(createStringRequest(requestForUsers, number));
    }

    private static String createStringRequest(Object... args) {
        logger.info("Create string request");
        StringBuilder request = new StringBuilder(ReaderUtils.getUrl());
        for (Object argument : args) {
            request.append(argument).append("/");
        }
        return request.toString();
    }
}
