package project.models;

import java.util.List;

public class Request {

    private String method;
    private String url;
    private String urlPattern;
    private Object headers;
    private List<Object> bodyPatterns;

    public Object getHeaders() {
        return headers;
    }

    public Request setHeaders(Object headers) {
        this.headers = headers;
        return this;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public Request setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
        return this;
    }

    public List<Object> getBodyPatterns() {
        return bodyPatterns;
    }

    public Request setBodyPatterns(List<Object> bodyPatterns) {
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
}
