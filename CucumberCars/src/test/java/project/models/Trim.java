package project.models;

import java.util.Objects;

public class Trim {

    private String nameTrim;
    private String engine;
    private String transmission;

    public String getNameTrim() {
        return nameTrim;
    }

    public void setNameTrim(String nameTrim) {
        this.nameTrim = nameTrim;
    }

    public String getEngine() {
        return engine;
    }

    public Trim setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public Trim setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trim trim = (Trim) o;
        return Objects.equals(engine, trim.engine) &&
                Objects.equals(transmission, trim.transmission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engine, transmission);
    }
}
