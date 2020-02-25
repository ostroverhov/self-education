package project.models;

import java.util.Map;

public class Headers {

    private String contentType;
    private Map customType;

    public Map getCustomType() {
        return customType;
    }

    public Headers setCustomType(Map customType) {
        this.customType = customType;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public Headers setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }
}
