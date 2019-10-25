package project.models;

import com.google.gson.annotations.SerializedName;

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
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sectionId='" + sectionId + '\'' +
                '}';
    }
}
