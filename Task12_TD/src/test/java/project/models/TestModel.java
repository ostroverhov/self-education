package project.models;

import aquality.selenium.logger.Logger;
import project.enums.StatusTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TestModel {

    private String name;
    private String method;
    private String status;
    private String startTime;
    private String endTime;
    private String duration;
    private String browser;
    private String env;
    private static final String patternDateTime = "yyyy-MM-dd hh:mm:ss";
    private static final Logger logger = Logger.getInstance();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusWord() {
        return StatusTest.getStatusTest(Integer.parseInt(getStatus()) - 1);
//        String result = null;
//        switch (getStatus()) {
//            case "1":
//                result = "Passed";
//            case "2":
//                result = "Failed";
//            case "3":
//                result = "Skipped";
//            case "4":
//                result = "Unfinished";
//            default:
//                logger.warn("wrong result");
//        }
//        return result;
    }

    public void setStatus(String status) {
        this.status = status.toUpperCase();
    }

    public String getStartTime() {
        return startTime;
    }

    public Date getStartDateTime() {
        Date date = null;
        try {
            date = new SimpleDateFormat(patternDateTime).parse(getStartTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getEnvironment() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestModel testModel = (TestModel) o;
        return Objects.equals(name, testModel.name) &&
                Objects.equals(method, testModel.method) &&
                Objects.equals(status, testModel.status) &&
                Objects.equals(startTime, testModel.startTime) &&
                Objects.equals(endTime, testModel.endTime) &&
                Objects.equals(duration, testModel.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, method, status, startTime, endTime, duration);
    }
}
