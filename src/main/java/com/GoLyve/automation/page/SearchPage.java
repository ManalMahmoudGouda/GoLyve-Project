package com.GoLyve.automation.page;

import com.GoLyve.automation.config.LocatorsConfig;
import com.GoLyve.automation.page.BasePage;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    //private By searchBoxLocator = By.name("q");
   public WebElement searchBoxLocator = driver.findElement(By.xpath(LocatorsConfig.getLocator("searchBox")));
   //public WebElement weatherWidgetLocator = driver.findElement(By.xpath(LocatorsConfig.getLocator("weatherWidget")));

    public SearchPage(WebDriver driver) {
        super(driver); // Pass WebDriver to BasePage
    }

    public void search(String query) {
        WebElement searchBox = waitForElement( searchBoxLocator); // Use BasePage's utility
        enterText(searchBox, query);
        searchBox.submit();
    }

    public WebElement getWeatherWidgetLocator() {
        return driver.findElement(By.xpath(LocatorsConfig.getLocator("weatherWidget")));
    }

    public WebElement getFlightWidgetLocator() {
        return driver.findElement(By.xpath(LocatorsConfig.getLocator("flightWidget")));
    }
    public WebElement getTemperatureElementLocator() {
        return driver.findElement(By.xpath(LocatorsConfig.getLocator("temperatureElement")));
    }
        public WebElement getWeatherConditionElementLocator(){
            return driver.findElement(By.xpath(LocatorsConfig.getLocator("conditionElement")));


}
    public WebElement getRestaurantWidgetLocator() {
        return driver.findElement(By.xpath(LocatorsConfig.getLocator("restaurantWidget")));
    }


    public WebElement getMorePlacesLocator(){
        return driver.findElement(By.xpath(LocatorsConfig.getLocator("morePlacesBtn")));


    }


//-----------------------------------Restuarnts Serach Methods------------------------//

    public void clickOnMorePlacesBtn() {
        driver.findElement(By.xpath(LocatorsConfig.getLocator("morePlacesBtn"))).click();
    }

    public List<WebElement> getRestaurantDetails(WebDriver driver) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement listOfRetedRestaurants = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LocatorsConfig.getLocator("fullListOfRetedRestaurants"))));
            System.out.println("Parent div loaded: " + listOfRetedRestaurants.isDisplayed());
            // Locate the parent div containing all restaurant details
            // Extract the list of restaurant details from the parent div
            WebDriverWait restaurantWait = new WebDriverWait(driver, Duration.ofSeconds(30));

            List<WebElement> restaurantDetails = listOfRetedRestaurants.findElements(By.xpath("restaurantDetails"));




            // Print each restaurant's details
            for (WebElement restaurant : restaurantDetails) {
               System.out.println("Restaurant HTML: " + restaurant.getAttribute("outerHTML"));

               System.out.println("Restaurant Details: " + restaurant.getText());
            }
            return listOfRetedRestaurants.findElements(By.xpath("restaurantDetails"));

        } catch (Exception e) {
           e.printStackTrace();
            return new ArrayList<>(); // Return an empty list in case of an error
        }
    }

    // Method to extract ratings from restaurant details
    public List<Double> extractRatings(List<WebElement> restaurantDetails) {
        List<Double> ratings = new ArrayList<>();
        for (WebElement restaurant : restaurantDetails) {
            System.out.println("Restaurant details: " + restaurant.getText());

            try {
                WebElement ratingElement = restaurant.findElement(By.xpath(LocatorsConfig.getLocator("ratingElement")));
                String ratingText = ratingElement.getAttribute("aria-label"); // Example: "Rated 4.8 out of 5"
                double rating = Double.parseDouble(ratingText.split(" ")[1]); // Extract numeric value
                ratings.add(rating);
            } catch (Exception e) {
                System.out.println("No rating found for a restaurant.");
            }
        }
        return ratings;
    }



    public List<Double> getRatings(WebDriver driver) {
        List<WebElement> restaurantDetails = getRestaurantDetails(driver);
        return extractRatings(restaurantDetails);
    }
    public WebElement getRatingElementLocator(){
        return driver.findElement(By.xpath(LocatorsConfig.getLocator("ratingElement")));


    }


}
