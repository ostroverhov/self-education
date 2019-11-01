package project.enums;

public enum NameProject {

    BERCUT("Bercut"),
    BRANDALLEY("Brand Alley"),
    ENVISIA("Envisia"),
    IOTA("Iota"),
    MEGAFON("Megafon"),
    NEWPROJECT(""),
    NEXAGE("Nexage");

    private String nameProject;

    NameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }
}
