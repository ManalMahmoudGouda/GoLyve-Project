package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class SearchUtils {

    private WebDriver driver;

    public SearchUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Renamed helper method to verifyRelevanceOfResults
    public void verifyRelevanceOfResults(By searchResultsLocator, String expectedText, String errorMessage, boolean shouldContainText) {
        List<WebElement> searchResults = driver.findElements(searchResultsLocator);

        // Initialize a flag to track whether any relevant result is found
        boolean isRelevant = false;

        // Iterate through all search results and check if they contain the expected text
        for (WebElement result : searchResults) {
            if (shouldContainText && result.getText().contains(expectedText)) {
                isRelevant = true;
                break;  // Exit the loop once we find the relevant result
            }
        }
        // Assert if a relevant result was found using TestNG
        Assert.assertTrue(isRelevant, errorMessage);
    }
}
