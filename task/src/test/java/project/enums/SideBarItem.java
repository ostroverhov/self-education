package project.enums;

public enum SideBarItem {

    BUILD("build"),
    FURNISH("furnish"),
    DECORATE("decorate"),
    LIGHTS("lights"),
    SHOPPING("shopping"),
    INFO("info");

    private String sideBarItem;

    SideBarItem(String sideBarItem) {
        this.sideBarItem = sideBarItem;
    }

    public String getSideBarItem() {
        return sideBarItem;
    }
}
