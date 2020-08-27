package enums

enum class CityItem(cityItem: String?) {

    LOSANGELES("Los Angeles"),
    ABUDHABI("Abu Dhabi");

    val city: String? = cityItem
}