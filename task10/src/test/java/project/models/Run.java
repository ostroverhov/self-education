package project.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Run run = (Run) o;
        return id == run.id &&
                Objects.equals(name, run.name) &&
                Objects.equals(suiteId, run.suiteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, suiteId);
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
