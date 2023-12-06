package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import Contracts.IWeatherService;
import Services.WeatherService;

class WeatherServiceJUnitTest {
		//********Important Note******\\
		//Some tests failed due to changes in output of weather site
		//We could have tested the constants in the output of weather site but that will not be JUnit Testing :)
	@Test
	void test() throws ExecutionException 
	{
		IWeatherService w = new WeatherService();
		String result = w.getCurrentWeather("London");
		String actual = "{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"base\":\"stations\",\"main\":{\"temp\":287.26,\"feels_like\":287.18,\"temp_min\":285.95,\"temp_max\":288.44,\"pressure\":1024,\"humidity\":94},\"visibility\":8000,\"wind\":{\"speed\":1.33,\"deg\":351,\"gust\":4.13},\"clouds\":{\"all\":90},\"dt\":1622838838,\"sys\":{\"type\":2,\"id\":2019646,\"country\":\"GB\",\"sunrise\":1622778415,\"sunset\":1622837466},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		assertEquals(actual,result);
	}
	@Test
	void test2() throws ExecutionException 
	{
		IWeatherService w = new WeatherService();
		String result = w.getCurrentWeather("");
		String actual = "{\"cod\":\"400\",\"message\":\"Nothing to geocode\"}";
		assertEquals(actual,result);
	}
	@Test
	void test3() throws ExecutionException 
	{
		IWeatherService w = new WeatherService();
		String result = w.getCurrentWeather(null);
		String actual = "{\"cod\":\"404\",\"message\":\"city not found\"}";
		assertEquals(actual,result);
	}
	@Test
	void test4() throws ExecutionException 
	{
		IWeatherService w = new WeatherService();
		String result = w.getCurrentWeather("Londo");
		String actual = "{\"cod\":\"404\",\"message\":\"city not found\"}";
		assertEquals(actual,result);
	}
	@Test
	void test5() throws ExecutionException 
	{
		IWeatherService w = new WeatherService();
		String result = w.getCurrentWeather(0);
		String actual = "{\"cod\":\"400\",\"message\":\"Invalid ID\"}";
		assertEquals(actual,result);
	}
	@Test
	void test6() throws ExecutionException 
	{
		IWeatherService w = new WeatherService();
		String result = w.getCurrentWeather(360630);
		String actual = "{\"coord\":{\"lon\":31.2497,\"lat\":30.0626},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":296.88,\"feels_like\":296.35,\"temp_min\":296.16,\"temp_max\":296.88,\"pressure\":1016,\"humidity\":40},\"visibility\":10000,\"wind\":{\"speed\":6.04,\"deg\":347,\"gust\":7.58},\"clouds\":{\"all\":0},\"dt\":1622837125,\"sys\":{\"type\":2,\"id\":2037059,\"country\":\"EG\",\"sunrise\":1622775232,\"sunset\":1622825587},\"timezone\":7200,\"id\":360630,\"name\":\"Cairo\",\"cod\":200}";
		assertEquals(actual,result);
	}
	@Test
	void test7() throws ExecutionException 
	{
		IWeatherService w = new WeatherService();
		String result = w.getCurrentWeather((float)30.0626,(float)31.2497);
		String actual = "{\"coord\":{\"lon\":31.2497,\"lat\":30.0626},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"base\":\"stations\",\"main\":{\"temp\":296.88,\"feels_like\":296.35,\"temp_min\":296.16,\"temp_max\":296.88,\"pressure\":1016,\"humidity\":40},\"visibility\":10000,\"wind\":{\"speed\":6.04,\"deg\":347,\"gust\":7.58},\"clouds\":{\"all\":0},\"dt\":1622837125,\"sys\":{\"type\":2,\"id\":2037059,\"country\":\"EG\",\"sunrise\":1622775232,\"sunset\":1622825587},\"timezone\":7200,\"id\":360630,\"name\":\"Cairo\",\"cod\":200}";
		assertEquals(actual,result);
	}
}
