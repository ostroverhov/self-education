package project.datastorage;

import framework.utils.RandomUtils;
import org.json.simple.JSONObject;

import java.util.TreeMap;

public class DataGenerator {

    public static String generateSuite() {
        TreeMap<String, String> suiteParameter = new TreeMap<>();
        suiteParameter.put("name", "Suite_" + RandomUtils.generateRandomNumber());
        suiteParameter.put("description", "Use the description to add additional context details");
        return new JSONObject(suiteParameter).toString();
    }

    public static String generateSection(int suiteId) {
        TreeMap<String, String> suiteParameter = new TreeMap<>();
        suiteParameter.put("name", "Section_" + RandomUtils.generateRandomNumber());
        suiteParameter.put("description", "Use the description to add additional context details");
        suiteParameter.put("suite_id", String.valueOf(suiteId));
        return new JSONObject(suiteParameter).toString();
    }

    public static String generateCase(int sectionId) {
        TreeMap<String, String> suiteParameter = new TreeMap<>();
        suiteParameter.put("title", "Case_" + RandomUtils.generateRandomNumber());
        suiteParameter.put("section_id", String.valueOf(sectionId));
        return new JSONObject(suiteParameter).toString();
    }

    public static String generateRun(int suiteId) {
        TreeMap<String, String> suiteParameter = new TreeMap<>();
        suiteParameter.put("name", "Run_" + RandomUtils.generateRandomNumber());
        suiteParameter.put("suite_id", String.valueOf(suiteId));
        return new JSONObject(suiteParameter).toString();
    }

    public static String generateResult() {
        TreeMap<String, Integer> suiteParameter = new TreeMap<>();
        suiteParameter.put("status_id", RandomUtils.generateRandomNumber());
//        suiteParameter.put("comment", String.valueOf(RandomUtils.generateRandomBoolean()));
        return new JSONObject(suiteParameter).toString();
    }
}
