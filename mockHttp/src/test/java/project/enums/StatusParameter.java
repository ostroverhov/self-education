package project.enums;

public enum StatusParameter {

    PASSED("1"),
    FAILED("5");

    private String description;

    StatusParameter(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
