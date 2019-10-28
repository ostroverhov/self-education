package project.models;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("status_id")
    private String statusId;

    @SerializedName("test_id")
    private int testId;

    @Override
    public String toString() {
        return "Result{" +
                "statusId='" + statusId + '\'' +
                ", testId=" + testId +
                '}';
    }
}
