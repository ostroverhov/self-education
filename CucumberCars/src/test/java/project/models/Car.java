package project.models;

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
}
