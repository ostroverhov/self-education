package project.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Section {

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
        Section section = (Section) o;
        return id == section.id &&
                Objects.equals(name, section.name) &&
                Objects.equals(suiteId, section.suiteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, suiteId);
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", suiteId='" + suiteId + '\'' +
                '}';
    }
}
