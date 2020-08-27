package project.datastorage;

import framework.utils.RandomUtils;
import org.json.simple.JSONObject;

import java.util.TreeMap;

public class DataGenerator {

    private static final int randomNumber = 100000;
    private static final int randomStatus = 5;

    public static String generateSuite() {
        TreeMap<String, String> suiteParameter = new TreeMap<>();
        suiteParameter.put("name", "Suite_" + getRandomInt(randomNumber));
        suiteParameter.put("description", "Use the description to add additional context details");
        return new JSONObject(suiteParameter).toString();
    }

    public static String generateSection(int suiteId) {
        TreeMap<String, String> sectionParameter = new TreeMap<>();
        sectionParameter.put("name", "Section_" + getRandomInt(randomNumber));
        sectionParameter.put("description", "Use the description to add additional context details");
        sectionParameter.put("suite_id", String.valueOf(suiteId));
        return new JSONObject(sectionParameter).toString();
    }

    public static String generateCase(int sectionId) {
        TreeMap<String, String> caseParameter = new TreeMap<>();
        caseParameter.put("title", "Case_" + getRandomInt(randomNumber));
        caseParameter.put("section_id", String.valueOf(sectionId));
        return new JSONObject(caseParameter).toString();
    }

    public static String generateRun(int suiteId) {
        TreeMap<String, String> runParameter = new TreeMap<>();
        runParameter.put("name", "Run_" + getRandomInt(randomNumber));
        runParameter.put("suite_id", String.valueOf(suiteId));
        return new JSONObject(runParameter).toString();
    }

    public static String generateResult() {
        TreeMap<String, Integer> resultParameter = new TreeMap<>();
        resultParameter.put("status_id", getRandomInt(randomStatus));
        return new JSONObject(resultParameter).toString();
    }

    private static int getRandomInt(int randomNumber) {
        return RandomUtils.generateRandomNumber(randomNumber);
    }
}
