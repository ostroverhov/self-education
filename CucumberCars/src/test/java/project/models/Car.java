package project.models;

import java.util.Objects;

public class Car {

    private String make;
    private String model;
    private String year;
    private Trim trim;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public Trim getTrim() {
        return trim;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(make, car.make) &&
                Objects.equals(model, car.model) &&
                Objects.equals(year, car.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, year);
    }
}
