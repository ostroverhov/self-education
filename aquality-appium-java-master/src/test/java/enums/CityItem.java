package enums;

public enum CityItem {

    LOSANGELES("Los Angeles"),
    ABUDHABI("Abu Dhabi");

    private String cityItem;

    CityItem(String cityItem) {
        this.cityItem = cityItem;
    }

    public String getCityItem() {
        return cityItem;
    }
}
