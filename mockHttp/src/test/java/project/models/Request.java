package project.models;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private String method;
    private String url;
    private String urlPattern;
    private HashMap<String, Map> queryParameters;
    private HashMap<String, String> bodyPatterns;

    public String getUrlPattern() {
        return urlPattern;
    }

    public Request setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
        return this;
    }

    public HashMap<String, String> getBodyPatterns() {
        return bodyPatterns;
    }

    public Request setBodyPatterns(HashMap<String, String> bodyPatterns) {
        this.bodyPatterns = bodyPatterns;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public Request setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Request setUrl(String url) {
        this.url = url;
        return this;
    }

    public HashMap<String, Map> getQueryParameters() {
        return queryParameters;
    }

    public Request setQueryParameters(HashMap<String, Map> queryParameters) {
        this.queryParameters = queryParameters;
        return this;
    }
}
