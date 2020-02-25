package project.models;

public class Response {

    private int status;
    private String body;
    private Headers headers;
    private String proxyBaseUrl;

    public String getProxyBaseUrl() {
        return proxyBaseUrl;
    }

    public Response setProxyBaseUrl(String proxyBaseUrl) {
        this.proxyBaseUrl = proxyBaseUrl;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Response setStatus(String status) {
        this.status = Integer.parseInt(status);
        return this;
    }

    public String getBody() {
        return body;
    }

    public Response setBody(String body) {
        this.body = body;
        return this;
    }

    public Headers getHeaders() {
        return headers;
    }

    public Response setHeaders(Headers headers) {
        this.headers = headers;
        return this;
    }
}
