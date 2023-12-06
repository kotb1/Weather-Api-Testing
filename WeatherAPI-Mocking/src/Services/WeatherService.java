package Services;

import Contracts.IWeatherService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.ExecutionException;

public class WeatherService implements IWeatherService {
	HttpClient client;
	HttpRequest request;
	HttpResponse response;
	String jsonResponse = "";
    @Override
    public String getCurrentWeather(String cityName) throws IllegalArgumentException, ExecutionException  {
        // TODO Auto-generated method stub
    	client = HttpClient.newHttpClient();
    	request = HttpRequest.newBuilder().uri(URI.create("http://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=c40310657d787ce22eb5d557b4c37745")).build();
    	try
    	{
    		response=client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get();
    		jsonResponse = response.body().toString();
    	}
    	catch(InterruptedException e)
    	{
    		e.printStackTrace();
    	}
    	return jsonResponse;
    }

    @Override
    public String getCurrentWeather(int cityId) throws ExecutionException {
        // TODO Auto-generated method stub
    	//c40310657d787ce22eb5d557b4c37745
    	client = HttpClient.newHttpClient();
    	request = HttpRequest.newBuilder().uri(URI.create("http://api.openweathermap.org/data/2.5/weather?id="+cityId+"&appid=c40310657d787ce22eb5d557b4c37745")).build();
    	try
    	{
    		response=client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get();
    		jsonResponse = response.body().toString();
    	}
    	catch(InterruptedException e)
    	{
    		e.printStackTrace();
    	}
    	return jsonResponse;
    }

    @Override
    public String getCurrentWeather(float latitude, float longitude) throws ExecutionException {
        // TODO Auto-generated method stub
        //c40310657d787ce22eb5d557b4c37745
    	client = HttpClient.newHttpClient();
    	request = HttpRequest.newBuilder().uri(URI.create("http://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid=c40310657d787ce22eb5d557b4c37745")).build();
    	try
    	{
    		response=client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).get();
    		jsonResponse = response.body().toString();
    	}
    	catch(InterruptedException e)
    	{
    		e.printStackTrace();
    	}
    	return jsonResponse;
    }

}
