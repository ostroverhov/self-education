package project.models;

public class Headers {

    private Object contentType;
    private String location;

    public String getLocation() {
        return location;
    }

    public Headers setLocation(String location) {
        this.location = location;
        return this;
    }

    public Object getContentType() {
        return contentType;
    }

    public Headers setContentType(Object contentType) {
        this.contentType = contentType;
        return this;
    }
}
