package com.GoLyve.automation.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class LocatorsConfig {

    private static JsonObject locators;
    // Load locators from JSON file(Reads the locators.json file and loads it into a JsonObject.)
    public static void loadLocators() throws IOException {
        FileReader reader = new FileReader("src/test/resources/locators.json");
        locators = JsonParser.parseReader(reader).getAsJsonObject();
    }

    // Get the locator for a given key
    public static String getLocator(String key) {
        return locators.get(key).getAsString();
    }

}
