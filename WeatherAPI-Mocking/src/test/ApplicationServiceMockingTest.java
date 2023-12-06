package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ExecutionException;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.jupiter.api.Test;

import Contracts.IJsonService;
import Contracts.IWeatherService;
import Services.ApplicationService;
import Services.objects;

class ApplicationServiceMockingTest {
	//(expected = IllegalArgumentException.class) is not working to test throw exception
	@Test
	void test_1() throws ExecutionException {
		Mockery mockingContext = new Mockery();
		Mockery mockingContext2 = new Mockery();
		IWeatherService mockedObject 	= mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		String cityname = "London";
		String big_string = "{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{\"temp\":287.51,\"feels_like\":287.46,\"temp_min\":285.85,\"temp_max\":288.86,\"pressure\":1024,\"humidity\":94},\"visibility\":5000,\"wind\":{\"speed\":1.6,\"deg\":355,\"gust\":4.93},\"clouds\":{\"all\":90},\"dt\":1622835277,\"sys\":{\"type\":2,\"id\":2019646,\"country\":\"GB\",\"sunrise\":1622778415,\"sunset\":1622837466},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		String string = "The coordinates are: longitude = -0.1257 ,latitude = 51.5085\r\n"
				+ "Base = stations\r\n"
				+ "The main are: Temperature = 288.03 ,Feels_like = 287.98 ,Temperature_min = 286.4 ,Temperature_max = 289.23 ,Pressure = 1023 ,Humidity = 92 ,Sea_level = 0 ,Ground_level = 0\r\n"
				+ "Visibility = 10000\r\n"
				+ "The Wind Properties are: Speed = 2.14 ,deg = 334 ,gust = 4.07\r\n"
				+ "The Clouds Properties are: All = 90\r\n"
				+ "DT = 1622807785\r\n"
				+ "The System Properties are: Type = 2 ,ID = 2019646 ,country = GB ,sunrise1622778415 ,sunset1622837466\r\n"
				+ "TimeZone = 3600\r\n"
				+ "ID = 2643743\r\n"
				+ "Name = London\r\n"
				+ "COD = 200";
		objects o = new objects();
		o.base="stations";
		o.coord.lat = 51.5085;
		o.coord.lon = -0.1257;
		o.main.temp=(float) 287.97;
		o.main.feels_like=(float) 287.94;
		o.main.temp_min = (float) 286.73;
		o.main.temp_max = (float) 288.84;
		o.main.pressure = 1023;
		o.main.humidity = 93;
		o.main.sea_level = 0;
		o.main.grnd_level=0;
		o.visibility = 7000;
		o.wind.speed = (float) 2.35;
		o.wind.deg = 333;
		o.wind.gust = (float) 4.69;
		o.clouds.all = 90;
		o.dt = 1622810069;
		o.sys.type = 2;
		o.sys.id = 2019646;
		o.sys.country = "GB";
		o.sys.sunrise = 1622778415;
		o.sys.sunset = 1622837466;
		o.timezone = 3600;
		o.id = 2643743;
		o.name = "London";
		o.cod = 200;
		mockingContext.checking(new Expectations() 
		{{
			oneOf(mockedObject).getCurrentWeather(cityname);
			will(returnValue(big_string));
		}});
		mockingContext2.checking(new Expectations() 
		{{
			oneOf(mockedObject2).fromJson(big_string, objects.class);
			will(returnValue(o));
			oneOf(mockedObject2).toJson(o);
			will(returnValue(string));
		}});
		ApplicationService w = new ApplicationService(mockedObject,mockedObject2);
		String s = w.getCurrentWeather(cityname);
		mockingContext.assertIsSatisfied();
		assertEquals(string,s);
	}
	@Test
	void test_2() throws ExecutionException {
		Mockery mockingContext = new Mockery();
		Mockery mockingContext2 = new Mockery();
		IWeatherService mockedObject 	= mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		int cityid = 2643743;
		String big_string = "{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{\"temp\":287.51,\"feels_like\":287.46,\"temp_min\":285.85,\"temp_max\":288.86,\"pressure\":1024,\"humidity\":94},\"visibility\":5000,\"wind\":{\"speed\":1.6,\"deg\":355,\"gust\":4.93},\"clouds\":{\"all\":90},\"dt\":1622835277,\"sys\":{\"type\":2,\"id\":2019646,\"country\":\"GB\",\"sunrise\":1622778415,\"sunset\":1622837466},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		String string = "The coordinates are: longitude = -0.1257 ,latitude = 51.5085\r\n"
				+ "Base = stations\r\n"
				+ "The main are: Temperature = 288.03 ,Feels_like = 287.98 ,Temperature_min = 286.4 ,Temperature_max = 289.23 ,Pressure = 1023 ,Humidity = 92 ,Sea_level = 0 ,Ground_level = 0\r\n"
				+ "Visibility = 10000\r\n"
				+ "The Wind Properties are: Speed = 2.14 ,deg = 334 ,gust = 4.07\r\n"
				+ "The Clouds Properties are: All = 90\r\n"
				+ "DT = 1622807785\r\n"
				+ "The System Properties are: Type = 2 ,ID = 2019646 ,country = GB ,sunrise1622778415 ,sunset1622837466\r\n"
				+ "TimeZone = 3600\r\n"
				+ "ID = 2643743\r\n"
				+ "Name = London\r\n"
				+ "COD = 200";
		objects o = new objects();
		o.base="stations";
		o.coord.lat = 51.5085;
		o.coord.lon = -0.1257;
		o.main.temp=(float) 287.97;
		o.main.feels_like=(float) 287.94;
		o.main.temp_min = (float) 286.73;
		o.main.temp_max = (float) 288.84;
		o.main.pressure = 1023;
		o.main.humidity = 93;
		o.main.sea_level = 0;
		o.main.grnd_level=0;
		o.visibility = 7000;
		o.wind.speed = (float) 2.35;
		o.wind.deg = 333;
		o.wind.gust = (float) 4.69;
		o.clouds.all = 90;
		o.dt = 1622810069;
		o.sys.type = 2;
		o.sys.id = 2019646;
		o.sys.country = "GB";
		o.sys.sunrise = 1622778415;
		o.sys.sunset = 1622837466;
		o.timezone = 3600;
		o.id = 2643743;
		o.name = "London";
		o.cod = 200;
		mockingContext.checking(new Expectations() 
		{{
			oneOf(mockedObject).getCurrentWeather(cityid);
			will(returnValue(big_string));
		}});
		mockingContext2.checking(new Expectations() 
		{{
			oneOf(mockedObject2).fromJson(big_string, objects.class);
			will(returnValue(o));
			oneOf(mockedObject2).toJson(o);
			will(returnValue(string));
		}});
		ApplicationService w = new ApplicationService(mockedObject,mockedObject2);
		String s = w.getCurrentWeather(cityid);
		mockingContext.assertIsSatisfied();
		assertEquals(string,s);
	}
	@Test
	void test_3() throws ExecutionException {
		Mockery mockingContext = new Mockery();
		Mockery mockingContext2 = new Mockery();
		IWeatherService mockedObject 	= mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		float lat = (float) 51.5085;
		float lon = (float) -0.1257;
		String big_string = "{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{\"temp\":287.51,\"feels_like\":287.46,\"temp_min\":285.85,\"temp_max\":288.86,\"pressure\":1024,\"humidity\":94},\"visibility\":5000,\"wind\":{\"speed\":1.6,\"deg\":355,\"gust\":4.93},\"clouds\":{\"all\":90},\"dt\":1622835277,\"sys\":{\"type\":2,\"id\":2019646,\"country\":\"GB\",\"sunrise\":1622778415,\"sunset\":1622837466},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		String string = "The coordinates are: longitude = -0.1257 ,latitude = 51.5085\r\n"
				+ "Base = stations\r\n"
				+ "The main are: Temperature = 288.03 ,Feels_like = 287.98 ,Temperature_min = 286.4 ,Temperature_max = 289.23 ,Pressure = 1023 ,Humidity = 92 ,Sea_level = 0 ,Ground_level = 0\r\n"
				+ "Visibility = 10000\r\n"
				+ "The Wind Properties are: Speed = 2.14 ,deg = 334 ,gust = 4.07\r\n"
				+ "The Clouds Properties are: All = 90\r\n"
				+ "DT = 1622807785\r\n"
				+ "The System Properties are: Type = 2 ,ID = 2019646 ,country = GB ,sunrise1622778415 ,sunset1622837466\r\n"
				+ "TimeZone = 3600\r\n"
				+ "ID = 2643743\r\n"
				+ "Name = London\r\n"
				+ "COD = 200";
		objects o = new objects();
		o.base="stations";
		o.coord.lat = 51.5085;
		o.coord.lon = -0.1257;
		o.main.temp=(float) 287.97;
		o.main.feels_like=(float) 287.94;
		o.main.temp_min = (float) 286.73;
		o.main.temp_max = (float) 288.84;
		o.main.pressure = 1023;
		o.main.humidity = 93;
		o.main.sea_level = 0;
		o.main.grnd_level=0;
		o.visibility = 7000;
		o.wind.speed = (float) 2.35;
		o.wind.deg = 333;
		o.wind.gust = (float) 4.69;
		o.clouds.all = 90;
		o.dt = 1622810069;
		o.sys.type = 2;
		o.sys.id = 2019646;
		o.sys.country = "GB";
		o.sys.sunrise = 1622778415;
		o.sys.sunset = 1622837466;
		o.timezone = 3600;
		o.id = 2643743;
		o.name = "London";
		o.cod = 200;
		mockingContext.checking(new Expectations() 
		{{
			oneOf(mockedObject).getCurrentWeather(lat,lon);
			will(returnValue(big_string));
		}});
		mockingContext2.checking(new Expectations() 
		{{
			oneOf(mockedObject2).fromJson(big_string, objects.class);
			will(returnValue(o));
			oneOf(mockedObject2).toJson(o);
			will(returnValue(string));
		}});
		ApplicationService w = new ApplicationService(mockedObject,mockedObject2);
		String s = w.getCurrentWeather(lat,lon);
		mockingContext.assertIsSatisfied();
		assertEquals(string,s);
	}
	@Test
	void test_4() throws ExecutionException {
		Mockery mockingContext = new Mockery();
		Mockery mockingContext2 = new Mockery();
		IWeatherService mockedObject 	= mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		String cityname = "Cair";
		mockingContext.checking(new Expectations() 
		{{
			oneOf(mockedObject).getCurrentWeather(cityname);
			will(returnValue("{\"cod\":\"404\",\"message\":\"city not found\"}\r\n"));
		}});
		ApplicationService w = new ApplicationService(mockedObject,mockedObject2);
		String s = w.getCurrentWeather("Cair");
		mockingContext.assertIsSatisfied();
		assertEquals("Error404",s);
	}
	@Test
	void test_5() throws ExecutionException {
		Mockery mockingContext = new Mockery();
		Mockery mockingContext2 = new Mockery();
		IWeatherService mockedObject 	= mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		String cityname = "";
		mockingContext.checking(new Expectations() 
		{{
			oneOf(mockedObject).getCurrentWeather(cityname);
			will(returnValue("{\"cod\":\"400\",\"message\":\"Nothing to geocode\"}"));
		}});
		ApplicationService w = new ApplicationService(mockedObject,mockedObject2);
		String s = w.getCurrentWeather("");
		mockingContext.assertIsSatisfied();
		assertNull(s);
	}
	@Test
	void test_6() throws ExecutionException {
		Mockery mockingContext = new Mockery();
		Mockery mockingContext2 = new Mockery();
		IWeatherService mockedObject 	= mockingContext.mock(IWeatherService.class);
		IJsonService mockedObject2 = mockingContext2.mock(IJsonService.class);
		int cityid = -44;
		mockingContext.checking(new Expectations() 
		{{
			oneOf(mockedObject).getCurrentWeather(cityid);
			will(returnValue("{\"cod\":\"400\",\"message\":\"Invalid ID\"}"));
		}});
		ApplicationService w = new ApplicationService(mockedObject,mockedObject2);
		String s = w.getCurrentWeather(cityid);
		mockingContext.assertIsSatisfied();
		String actual = "Invalid ID";
		assertEquals(actual,s);
	}
}
