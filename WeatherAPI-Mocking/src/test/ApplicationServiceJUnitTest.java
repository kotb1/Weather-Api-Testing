package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import Contracts.IJsonService;
import Contracts.IWeatherService;
import Services.ApplicationService;
import Services.GsonService;
import Services.WeatherService;

class ApplicationServiceJUnitTest {
	//********Important Note******\\
	//Some tests failed due to changes in output of weather site
	//We could have tested the constants in the output of weather site but that will not be JUnit Testing :)
	@Test
	void test() throws ExecutionException 
	{
		IWeatherService w = new WeatherService();
		IJsonService i = new GsonService();
		ApplicationService k = new ApplicationService(w,i);
		String result = k.getCurrentWeather("");
		assertNull(result);
	}
	@Test
	void test2() throws ExecutionException 
	{
		//Here the website when i give him null return null not no city is found 
		IWeatherService w = new WeatherService();
		IJsonService i = new GsonService();
		ApplicationService k = new ApplicationService(w,i);
		String result = k.getCurrentWeather(null);
		assertNull(result);
	}
	@Test
	void test3() throws ExecutionException 
	{
		IWeatherService w = new WeatherService();
		IJsonService i = new GsonService();
		ApplicationService k = new ApplicationService(w,i);
		String result = k.getCurrentWeather("cair");
		assertEquals("Error404",result);
	}
	@Test
	void test4() throws ExecutionException 
	{
		IWeatherService w = new WeatherService();
		IJsonService i = new GsonService();
		ApplicationService k = new ApplicationService(w,i);
		String result = k.getCurrentWeather("London");
		String actual = "The coordinates are: longitude = -0.1257 ,latitude = 51.5085\r\n"
				+ "Base = stations\r\n"
				+ "The main are: Temperature = 287.37 ,Feels_like = 287.3 ,Temperature_min = 285.76 ,Temperature_max = 288.53 ,Pressure = 1024 ,Humidity = 94 ,Sea_level = 0 ,Ground_level = 0\r\n"
				+ "Visibility = 5000\r\n"
				+ "The Wind Properties are: Speed = 1.6 ,deg = 355 ,gust = 4.93\r\n"
				+ "The Clouds Properties are: All = 90\r\n"
				+ "DT = 1622835953\r\n"
				+ "The System Properties are: Type = 2 ,ID = 2019646 ,country = GB ,sunrise1622778415 ,sunset1622837466\r\n"
				+ "TimeZone = 3600\r\n"
				+ "ID = 2643743\r\n"
				+ "Name = London\r\n"
				+ "COD = 200";
		assertEquals(actual,result);
	}
	@Test
	void test5() throws ExecutionException 
	{
		IWeatherService w = new WeatherService();
		IJsonService i = new GsonService();
		ApplicationService k = new ApplicationService(w,i);
		String result = k.getCurrentWeather(2643743);
		String actual = "The coordinates are: longitude = -0.1257 ,latitude = 51.5085\n"
				+ "Base = stations\n"
				+ "The main are: Temperature = 287.59 ,Feels_like = 287.52 ,Temperature_min = 285.85 ,Temperature_max = 289.4 ,Pressure = 1023 ,Humidity = 93 ,Sea_level = 0 ,Ground_level = 0\n"
				+ "Visibility = 10000\n"
				+ "The Wind Properties are: Speed = 2.07 ,deg = 347 ,gust = 5.59\n"
				+ "The Clouds Properties are: All = 90\n"
				+ "DT = 1622831882\n"
				+ "The System Properties are: Type = 2 ,ID = 2019646 ,country = GB ,sunrise1622778415 ,sunset1622837466\n"
				+ "TimeZone = 3600\n"
				+ "ID = 2643743\n"
				+ "Name = London\n"
				+ "COD = 200";
		assertEquals(actual,result);
	}
	@Test
	void test6() throws ExecutionException 
	{
		IWeatherService w = new WeatherService();
		IJsonService i = new GsonService();
		ApplicationService k = new ApplicationService(w,i);
		String result = k.getCurrentWeather(0);
		String actual = "Invalid ID";
		assertEquals(actual,result);
	}
	@Test
	void test7() throws ExecutionException 
	{
		IWeatherService w = new WeatherService();
		IJsonService i = new GsonService();
		ApplicationService k = new ApplicationService(w,i);
		String result = k.getCurrentWeather((float)51.5085,(float)-0.1257);
		String actual = "The coordinates are: longitude = -0.1278 ,latitude = 51.5074\n"
				+ "Base = stations\n"
				+ "The main are: Temperature = 287.25 ,Feels_like = 287.17 ,Temperature_min = 285.87 ,Temperature_max = 288.57 ,Pressure = 1024 ,Humidity = 94 ,Sea_level = 0 ,Ground_level = 0\n"
				+ "Visibility = 4000\n"
				+ "The Wind Properties are: Speed = 1.6 ,deg = 355 ,gust = 4.92\n"
				+ "The Clouds Properties are: All = 90\n"
				+ "DT = 1622838061\n"
				+ "The System Properties are: Type = 2 ,ID = 2019646 ,country = GB ,sunrise1622778415 ,sunset1622837466\n"
				+ "TimeZone = 3600\n"
				+ "ID = 2643743\n"
				+ "Name = London\n"
				+ "COD = 200";
		assertEquals(actual,result);
	}
}
