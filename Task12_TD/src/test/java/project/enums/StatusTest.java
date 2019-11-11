package project.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum StatusTest {

    PASSED("Passed"),
    FAILED("Failed"),
    SKIPPED("Skipped"),
    UNFINISHED("Unfinished");

    private String statusTest;

    StatusTest(String statusTest) {
        this.statusTest = statusTest;
    }

    private static final List<StatusTest> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    public static String getStatusTest(int numberStatus) {
        return VALUES.get(numberStatus).statusTest;
    }
}
