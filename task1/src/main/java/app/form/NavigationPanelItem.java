package app.form;

public enum NavigationPanelItem {

    SUMMARY("Summary"),
    DEVICES("Devices"),
    LICENSES("Licenses"),
    DOWNLOADS("Downloads");

    private String panelItem;

    NavigationPanelItem(String panelItem) {
        this.panelItem = panelItem;
    }

    public String getPanelItem() {
        return panelItem;
    }
}
