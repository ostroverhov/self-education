package project.models;

import com.google.gson.annotations.SerializedName;

public class ResultTest {

    @SerializedName("test_id")
    private int testId;

    @SerializedName("status_id")
    private int statusId;

    @SerializedName("suite_id")
    private String suiteId;

    public int getTestId() {
        return testId;
    }

    public int getStatusId() {
        return statusId;
    }

    public String getSuiteId() {
        return suiteId;
    }
}