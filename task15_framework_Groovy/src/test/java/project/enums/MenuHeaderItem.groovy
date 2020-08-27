package project.enums

enum MenuHeaderItem {
    CARSFORSALE("Cars for Sale"),
    SELLYOURCAR("Sell Your Car"),
    SERVICEANDREPAIR("Service & Repair"),
    RESEARCH("Research"),
    VIDEOANDREVIEWS("Videos & Reviews");

    private String menuItem

    MenuHeaderItem(String menuItem) {
        this.menuItem = menuItem
    }

    String getMenuItem() {
        return menuItem
    }
}