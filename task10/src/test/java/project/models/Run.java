package project.models;

import com.google.gson.annotations.SerializedName;

public class Run {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("suite_id")
    private String suiteId;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Run{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", suiteId='" + suiteId + '\'' +
                '}';
    }
}
