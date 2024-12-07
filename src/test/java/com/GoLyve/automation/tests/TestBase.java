package com.GoLyve.automation.tests;

import com.GoLyve.automation.config.LocatorsConfig;
import com.GoLyve.automation.config.ReadJsonConfigFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import static com.github.dockerjava.core.DockerConfigFile.loadConfig;

public class TestBase {
    protected WebDriver driver;
    private ReadJsonConfigFile readConfig;
private LocatorsConfig locatorsConfig;
    @BeforeClass
    public void setup() throws IOException {

        // Set up WebDriver using WebDriverManager
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriverManager.chromedriver().create();
        driver = new ChromeDriver();

            // Load configuration from JSON
             readConfig = loadConfig();

            // Validate that config is loaded
            if (readConfig == null) {
                throw new RuntimeException("Failed to load configuration file!");
            }
            locatorsConfig.loadLocators();
            // Navigate to the base URL from the config
            driver.get(readConfig.getBaseUrl()); // Always navigate to Google homepage
            driver.manage().window().maximize();

    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
          driver.quit(); // Close the browser
       }
    }

    private ReadJsonConfigFile loadConfig() {
        try {
            // Load the JSON file into the Config class
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File("src/test/resources/config.json"), ReadJsonConfigFile.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    // Provide access to config for test classes
    protected ReadJsonConfigFile getConfig() {
        return readConfig;
    }
}