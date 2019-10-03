package project.models;

public class Furniture {

    private String pathToImageFromSideBar;
    private String pathToImageOnWorkSpace;
    private String nameFurniture;

    public Furniture(String pathToImageFromSideBar, String pathToImageOnWorkSpace, String nameFurniture) {
        this.pathToImageFromSideBar = pathToImageFromSideBar;
        this.pathToImageOnWorkSpace = pathToImageOnWorkSpace;
        this.nameFurniture = nameFurniture;
    }

    public String getNameFurniture() {
        return nameFurniture;
    }

    public String getPathToImageFromSideBar() {
        return pathToImageFromSideBar;
    }

    public String getPathToImageOnWorkSpace() {
        return pathToImageOnWorkSpace;
    }
}
