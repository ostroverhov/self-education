package framework.configurations;

import aquality.selenium.utils.JsonFile;

public enum Environment {

    PROD("prod"),
    STAGE("stage");

    private JsonFile configurationFile;

    Environment(String name) {
        configurationFile = new JsonFile(String.format("environment/%1$s/config.json", name));
    }

    public String getStartUrl() {
        return String.valueOf(configurationFile.getValue("/startUrl"));
    }
}