package aquality.appium.configuration;

import aquality.selenium.configuration.ILoggerConfiguration;
import aquality.selenium.configuration.IRetryConfiguration;
import aquality.selenium.configuration.LoggerConfiguration;
import aquality.selenium.configuration.RetryConfiguration;
import aquality.selenium.utils.JsonFile;

public class Configuration implements IConfiguration{

    private static ThreadLocal<Configuration> instance = ThreadLocal.withInitial(Configuration::new);
    private final ITimeoutConfiguration timeoutConfiguration;
    private final IRetryConfiguration retryConfiguration;
    private final IApplicationProfile applicationProfile;
    private final ILoggerConfiguration loggerConfiguration;

    private Configuration() {
        JsonFile settings = getSettings();
        timeoutConfiguration = new TimeoutConfiguration(settings);
        applicationProfile = new ApplicationProfile(settings);
        retryConfiguration = new RetryConfiguration(settings);
        loggerConfiguration = new LoggerConfiguration(settings);
    }

    public static Configuration getInstance() {
        return instance.get();
    }

    @Override
    public IApplicationProfile getApplicationProfile() {
        return applicationProfile;
    }

    @Override
    public ITimeoutConfiguration getTimeoutConfiguration() {
        return timeoutConfiguration;
    }

    @Override
    public IRetryConfiguration getRetryConfiguration() {
        return retryConfiguration;
    }

    @Override
    public ILoggerConfiguration getLoggerConfiguration() {
        return loggerConfiguration;
    }

    private JsonFile getSettings() {
        String settingsProfile = System.getProperty("profile") == null ? "settings.json" : "settings." + System.getProperty("profile") + ".json";
        return new JsonFile(settingsProfile);
    }
}