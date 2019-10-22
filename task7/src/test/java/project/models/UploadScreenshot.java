package project.models;

import com.google.gson.annotations.SerializedName;

public class UploadScreenshot {

    public String getUrl() {
        return url;
    }

    @SerializedName("url")
    private String url;
}
