package project.models;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("status_id")
    private String statusId;

    @SerializedName("comment")
    private String comment;

    @Override
    public String toString() {
        return "Result{" +
                "statusId='" + statusId + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
