package Services;

import java.util.concurrent.ExecutionException;

import Contracts.IJsonService;
import Contracts.IWeatherService;

public class ApplicationService {
    private IWeatherService weatherService;
    private IJsonService jsonService;

    public ApplicationService(IWeatherService wService, IJsonService jService) {
        weatherService = wService;
        jsonService = jService;
    }

    public String getCurrentWeather(String cityName) throws ExecutionException {
        // early exits if any
        // invoke weatherService method with cityName
        // check response for errors and if so early exit
        // parse response from weatherService using jsonService
        // return appropriate response
    	String big_string = weatherService.getCurrentWeather(cityName);
    	String string;
    	if(big_string.substring(8,11).equals("400"))
    	{
    		string = null;
    		return string;
    	}
    	else if(big_string.substring(8,11).equals("404"))
    	{
    		string = "Error404";
    		return string;
    	}
    	else
    	{
    		string = jsonService.toJson(jsonService.fromJson(big_string, objects.class));
    		return string;
    	}
    }
    public String getCurrentWeather(int cityId) throws ExecutionException {
        // early exits if any
        // invoke weatherService method with cityName
        // check response for errors and if so early exit
        // parse response from weatherService using jsonService
        // return appropriate response
    	String big_string = weatherService.getCurrentWeather(cityId);
    	String string;
    	if(big_string.substring(8,11).equals("400"))
    	{
    		string = "Invalid ID";
    		return string;
    	}
    	else
    	{
    		string = jsonService.toJson(jsonService.fromJson(big_string, objects.class));
    		return string;
    	}
    }
    public String getCurrentWeather(float lat ,float lon) throws ExecutionException {
        // early exits if any
        // invoke weatherService method with cityName
        // check response for errors and if so early exit
        // parse response from weatherService using jsonService
        // return appropriate response
    	String big_string = weatherService.getCurrentWeather(lat,lon);
    	String string;
    	if(big_string.substring(8,11).equals("400"))
    	{
    		string = null;
    		return string;
    	}
    	else if(big_string.substring(8,11).equals("404"))
    	{
    		string = "Error404";
    		return string;
    	}
    	else
    	{
    		string = jsonService.toJson(jsonService.fromJson(big_string, objects.class));
    		return string;
    	}
    }
}
