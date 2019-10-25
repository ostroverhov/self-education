package project.models;

import com.google.gson.annotations.SerializedName;

public class Suite {

    @SerializedName("project_id")
    private String project_id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("id")
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Suite{" +
                "project_id='" + project_id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
