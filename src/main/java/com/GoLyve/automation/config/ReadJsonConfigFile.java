package com.GoLyve.automation.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReadJsonConfigFile {
        private String baseUrl;
        private String apiKey;
        private int timeout;
        private int maxRetries;
        private String searchQuery;
        private String expectedTitle;
        private String expectedResultText;
        private String searchQueryInUrl;
        private String searchQueryInSearchBox;
    @JsonProperty("WeatherSearchQuery")
    private  String weatherSearchQuery;
        private String expectedFlightWidgetText;
        private String expectedRelevantResultsText;
        private  String expectedWeathertWidgetText;
        @JsonProperty("ErrorMsgOfRelevantResults")
        private String errorMsgOfRelevantResults;
       @JsonProperty("ErrorMsgOfFlightWidget")
       private  String errorMsgOfFlightWidget;

    @JsonProperty("ErrorMsgOfTemperature")
       private String errorMsgOfTemperature;
      @JsonProperty("ErrorMsgOfWeatherWidget")
      private  String errorMsgOfWeatherWidget;

    @JsonProperty("ErrorMsgOfRestaurantWidget")

private  String errorMsgOfRestaurantWidget;

    @JsonProperty("ErrorMsgOfConditionAndLocation")
      private String errorMsgOfConditionAndLocation;

    public String getRestaurantSearchQuery() {
        return restaurantSearchQuery;
    }

    public void setRestaurantSearchQuery(String restaurantSearchQuery) {
        this.restaurantSearchQuery = restaurantSearchQuery;
    }

    @JsonProperty("RestaurantSearchQuery")
    private String restaurantSearchQuery;
    @JsonProperty("TemperatureElementNotFound")
    private String temperatureElementNotFound;

    @JsonProperty("ConditionAndLocationElementNotFound")
    private String conditionAndLocationElementNotFound;

    // Getters and setters for all fields

        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public int getTimeout() {
            return timeout;
        }

        public void setTimeout(int timeout) {
            this.timeout = timeout;
        }

        public int getMaxRetries() {
            return maxRetries;
        }

        public void setMaxRetries(int maxRetries) {
            this.maxRetries = maxRetries;
        }

        public String getSearchQuery() {
            return searchQuery;
        }

        public void setSearchQuery(String searchQuery) {
            this.searchQuery = searchQuery;
        }

        public String getExpectedTitle() {
            return expectedTitle;
        }

        public void setExpectedTitle(String expectedTitle) {
            this.expectedTitle = expectedTitle;
        }

        public String getExpectedResultText() {
            return expectedResultText;
        }

        public void setExpectedResultText(String expectedResultText) {
            this.expectedResultText = expectedResultText;
        }

        public String getSearchQueryInUrl() {
            return searchQueryInUrl;
        }

        public void setSearchQueryInUrl(String searchQueryInUrl) {
            this.searchQueryInUrl = searchQueryInUrl;
        }

        public String getSearchQueryInSearchBox() {
            return searchQueryInSearchBox;
        }

        public void setSearchQueryInSearchBox(String searchQueryInSearchBox) {
            this.searchQueryInSearchBox = searchQueryInSearchBox;
        }
    public String getExpectedFlightWidgetText() {
        return expectedFlightWidgetText;
    }

    public void setExpectedFlightWidgetText(String expectedFlightWidgetText) {
        this.expectedFlightWidgetText = expectedFlightWidgetText;
    }

    public String getExpectedRelevantResultsText() {
        return expectedRelevantResultsText;
    }

    public void setExpectedRelevantResultsText(String expectedRelevantResultsText) {
        this.expectedRelevantResultsText = expectedRelevantResultsText;
    }
    public String getWeatherSearchQuery() {
        return weatherSearchQuery;
    }

    public void setWeatherSearchQuery(String weatherSearchQuery) {
        this.weatherSearchQuery = weatherSearchQuery;
    }

    public String getExpectedWeathertWidgetText() {
        return expectedWeathertWidgetText;
    }

    public void setExpectedWeathertWidgetText(String expectedWeathertWidgetText) {
        this.expectedWeathertWidgetText = expectedWeathertWidgetText;
    }

    public String getErrorMsgOfRelevantResults() {
        return errorMsgOfRelevantResults;
    }

    public void setErrorMsgOfRelevantResults(String errorMsgOfRelevantResults) {
        this.errorMsgOfRelevantResults = errorMsgOfRelevantResults;
    }

    public String getErrorMsgOfFlightWidget() {
        return errorMsgOfFlightWidget;
    }

    public void setErrorMsgOfFlightWidget(String errorMsgOfFlightWidget) {
        this.errorMsgOfFlightWidget = errorMsgOfFlightWidget;
    }

    public String getErrorMsgOfWeatherWidget() {
        return errorMsgOfWeatherWidget;
    }

    public void setErrorMsgOfWeatherWidget(String errorMsgOfWeatherWidget) {
        this.errorMsgOfWeatherWidget = errorMsgOfWeatherWidget;
    }

    public String getErrorMsgOfTemperature() {
        return errorMsgOfTemperature;
    }

    public void setErrorMsgOfTemperature(String errorMsgOfTemperature) {
        this.errorMsgOfTemperature = errorMsgOfTemperature;
    }
    public String getErrorMsgOfConditionAndLocation() {
        return errorMsgOfConditionAndLocation;
    }

    public void setErrorMsgOfConditionAndLocation(String errorMsgOfConditionAndLocation) {
        this.errorMsgOfConditionAndLocation = errorMsgOfConditionAndLocation;
    }

    public String getTemperatureElementNotFound() {
        return temperatureElementNotFound;
    }

    public void setTemperatureElementNotFound(String temperatureElementNotFound) {
        this.temperatureElementNotFound = temperatureElementNotFound;
    }

    public String getConditionAndLocationElementNotFound() {
        return conditionAndLocationElementNotFound;
    }

    public void setConditionAndLocationElementNotFound(String conditionAndLocationElementNotFound) {
        this.conditionAndLocationElementNotFound = conditionAndLocationElementNotFound;
    }

    public String getErrorMsgOfRestaurantWidget() {
        return errorMsgOfRestaurantWidget;
    }

    public void setErrorMsgOfRestaurantWidget(String errorMsgOfRestaurantWidget) {
        this.errorMsgOfRestaurantWidget = errorMsgOfRestaurantWidget;
    }


}


