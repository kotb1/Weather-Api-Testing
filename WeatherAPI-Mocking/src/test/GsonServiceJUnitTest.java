package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Contracts.IJsonService;
import Services.GsonService;
import Services.objects;

class GsonServiceJUnitTest {
		//********Important Note******\\
		//Some tests failed due to changes in output of weather site
		//We could have tested the constants in the output of weather site but that will not be JUnit Testing :)
	@Test
	void test()
	{
		IJsonService i = new GsonService();
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
		String result = i.toJson(o);
		String actual = "The coordinates are: longitude = -0.1257 ,latitude = 51.5085\n"
				+ "Base = stations\n"
				+ "The main are: Temperature = 287.97 ,Feels_like = 287.94 ,Temperature_min = 286.73 ,Temperature_max = 288.84 ,Pressure = 1023 ,Humidity = 93 ,Sea_level = 0 ,Ground_level = 0\n"
				+ "Visibility = 7000\n"
				+ "The Wind Properties are: Speed = 2.35 ,deg = 333 ,gust = 4.69\n"
				+ "The Clouds Properties are: All = 90\n"
				+ "DT = 1622810069\n"
				+ "The System Properties are: Type = 2 ,ID = 2019646 ,country = GB ,sunrise1622778415 ,sunset1622837466\n"
				+ "TimeZone = 3600\n"
				+ "ID = 2643743\n"
				+ "Name = London\n"
				+ "COD = 200";
		assertEquals(actual,result);		
	}
	@Test
	void test2() 
	{
		IJsonService i = new GsonService();
		String big_string = "{\"coord\":{\"lon\":-0.1257,\"lat\":51.5085},\"weather\":[{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{\"temp\":287.51,\"feels_like\":287.46,\"temp_min\":285.85,\"temp_max\":288.86,\"pressure\":1024,\"humidity\":94},\"visibility\":5000,\"wind\":{\"speed\":1.6,\"deg\":355,\"gust\":4.93},\"clouds\":{\"all\":90},\"dt\":1622835277,\"sys\":{\"type\":2,\"id\":2019646,\"country\":\"GB\",\"sunrise\":1622778415,\"sunset\":1622837466},\"timezone\":3600,\"id\":2643743,\"name\":\"London\",\"cod\":200}";
		objects o = i.fromJson(big_string,objects.class);
		objects o2 = new objects();
		o2.base="stations";
		o2.coord.lat = 51.5085;
		o2.coord.lon = -0.1257;
		o2.main.temp=(float) 287.97;
		o2.main.feels_like=(float) 287.94;
		o2.main.temp_min = (float) 286.73;
		o2.main.temp_max = (float) 288.84;
		o2.main.pressure = 1023;
		o2.main.humidity = 93;
		o2.main.sea_level = 0;
		o2.main.grnd_level=0;
		o2.visibility = 7000;
		o2.wind.speed = (float) 2.35;
		o2.wind.deg = 333;
		o2.wind.gust = (float) 4.69;
		o2.clouds.all = 90;
		o2.dt = 1622810069;
		o2.sys.type = 2;
		o2.sys.id = 2019646;
		o2.sys.country = "GB";
		o2.sys.sunrise = 1622778415;
		o2.sys.sunset = 1622837466;
		o2.timezone = 3600;
		o2.id = 2643743;
		o2.name = "London";
		o2.cod = 200;
		assertEquals(o2.name,o.name);
		assertEquals(o2.coord.lat,o.coord.lat);
		assertEquals(o2.coord.lon,o.coord.lon);
	}

}
