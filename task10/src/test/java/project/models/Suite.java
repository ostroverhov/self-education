package project.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suite suite = (Suite) o;
        return id == suite.id &&
                Objects.equals(project_id, suite.project_id) &&
                Objects.equals(name, suite.name) &&
                Objects.equals(description, suite.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project_id, name, description, id);
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
