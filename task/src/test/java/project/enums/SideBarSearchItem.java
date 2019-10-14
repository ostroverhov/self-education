package project.enums;

public enum SideBarSearchItem {

    ACCESSORIES("Accessories"),
    ARCHITECTURE("Architecture"),
    BATHROOM("Bathroom"),
    BEDROOM("Bedroom"),
    CHRISTMAS("Christmas"),
    DININGROOM("Dining room");

    private String sideBarSearchItem;

    SideBarSearchItem(String sideBarSearchItem) {
        this.sideBarSearchItem = sideBarSearchItem;
    }

    public String getSideBarSearchItem() {
        return sideBarSearchItem;
    }
}
