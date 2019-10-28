package project.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Case {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("section_id")
    private String sectionId;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return id == aCase.id &&
                Objects.equals(title, aCase.title) &&
                Objects.equals(sectionId, aCase.sectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, sectionId);
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sectionId='" + sectionId + '\'' +
                '}';
    }
}
