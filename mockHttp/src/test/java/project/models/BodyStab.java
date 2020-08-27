package project.models;

public class BodyStab {

    private Request request;
    private Response response;

    public Request getRequest() {
        return request;
    }

    public BodyStab setRequest(Request request) {
        this.request = request;
        return this;
    }

    public Response getResponse() {
        return response;
    }

    public BodyStab setResponse(Response response) {
        this.response = response;
        return this;
    }
}
