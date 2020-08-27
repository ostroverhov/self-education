package framework.configurations;


public class Configuration {
    private static Environment currentEnvironment;

    private Configuration() {
    }

    public static synchronized Environment getCurrentEnvironment() {
        if (currentEnvironment == null)
            currentEnvironment = new Environment(System.getProperty("environment") != null ? System.getProperty("environment")
                    : "stage");
        return currentEnvironment;
    }

}
