package app.models;

public class ModelMessage {

    private String subject;
    private String body;

    public ModelMessage(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
