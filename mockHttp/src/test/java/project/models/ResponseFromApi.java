package project.models;

import java.util.Objects;

public class ResponseFromApi {

    private String statusCode;
    private String body;

    public String getStatusCode() {
        return statusCode;
    }

    public ResponseFromApi setStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getBody() {
        return body;
    }

    public ResponseFromApi setBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseFromApi that = (ResponseFromApi) o;
        return Objects.equals(statusCode, that.statusCode) &&
                Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, body);
    }
}
