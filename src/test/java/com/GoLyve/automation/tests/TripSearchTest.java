package com.GoLyve.automation.tests;

import com.GoLyve.automation.page.SearchPage;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

public class TripSearchTest extends TestBase {
    @Test(priority = 1)
    public void testSearchFlights() {

            // Get dynamic search query from config
            String searchQuery = getConfig().getSearchQuery();

            // Create SearchPage object
            SearchPage searchPage = new SearchPage(driver);

            // Step 1: Perform search for flights from Cairo to Marsa Alam
            searchPage.search(searchQuery);

            // Step 2: Verify flight widget
            searchPage.scrollToElementAndWaitToVisible(driver, searchPage.getFlightWidgetLocator());
            Assert.assertTrue(searchPage.isElementVisible(searchPage.getFlightWidgetLocator()), getConfig().getErrorMsgOfFlightWidget());

            // Step 3: Verify relevance of results
            List<WebElement> searchResults = driver.findElements(By.cssSelector("div.g"));
            boolean isRelevant = false;

            for (WebElement result : searchResults) {
                if (result.getText().contains(getConfig().getExpectedRelevantResultsText())) {
                    isRelevant = true;
                    break;
                }
            }
            Assert.assertTrue(isRelevant, getConfig().getErrorMsgOfRelevantResults());
        }



    @Test (priority = 2)
    public void testSearchWeather() {
        // Step 1: Perform search for weather in Marsa Alam
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search(getConfig().getWeatherSearchQuery());

        // Step 2: Verify that the weather widget for Marsa Alam is displayed
        searchPage.scrollToElementAndWaitToVisible(driver, searchPage.getWeatherWidgetLocator());
        Assert.assertTrue(searchPage.isElementVisible(searchPage.getWeatherWidgetLocator()), getConfig().getErrorMsgOfWeatherWidget());

        // Step 3: Optional: Verify specific weather details (e.g., temperature)
        try {
            Assert.assertNotNull(searchPage.getTemperatureElementLocator(), getConfig().getErrorMsgOfTemperature());
        } catch (NoSuchElementException e) {
            Assert.fail(getConfig().getTemperatureElementNotFound());
        }

        // Step 4: Also check other weather data, like condition, location.
        try {
            Assert.assertNotNull(searchPage.getWeatherConditionElementLocator(),getConfig().getErrorMsgOfConditionAndLocation());
        } catch (NoSuchElementException e) {
            Assert.fail(getConfig().getConditionAndLocationElementNotFound());
        }
    }
    @Test (priority = 3)
    public void testSearchRestaurant(){
        // Step 1: Perform search for Restaurant in Marsa Alam
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search(getConfig().getRestaurantSearchQuery());

        // Step 2: Verify that the Restaurant widget for Marsa Alam is displayed
        Assert.assertTrue(searchPage.isElementVisible(searchPage.getRestaurantWidgetLocator()), getConfig().getErrorMsgOfRestaurantWidget());
        //Click on MorePlaces Btn
        searchPage.scrollToElementAndWaitToVisible(driver, searchPage.getMorePlacesLocator());

        searchPage.clickOnMorePlacesBtn();

        try {

            // Step 2: Fetch restaurant details
            List<WebElement> restaurantDetails = searchPage.getRestaurantDetails(driver);
            System.out.println("Number of restaurants found: " + restaurantDetails.size());
            // Assertion: Verify that the number of restaurants is greater than zero
            Assert.assertTrue(
                    !restaurantDetails.isEmpty(),
                    "No restaurants found. Expected at least one restaurant."
            );
            // Step 3: use getRatings for a combined call
            List<Double> combinedRatings = searchPage.getRatings(driver);
            System.out.println("Combined Ratings: " + combinedRatings);
            // Assertion: Verify that ratings list is not empty
            Assert.assertFalse(
                    combinedRatings.isEmpty(),
                    "Ratings list is empty. Expected ratings for at least one restaurant."
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    }


