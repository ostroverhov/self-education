package project.models;

import java.util.Objects;

public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) &&
                Objects.equals(suite, address.suite) &&
                Objects.equals(city, address.city) &&
                Objects.equals(zipcode, address.zipcode) &&
                Objects.equals(geo, address.geo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, suite, city, zipcode, geo);
    }
}
