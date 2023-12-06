package Services;

public class objects 
{
	public coord coord;
	public String base;
	public main main;
	public int visibility;
	public wind wind;
	public clouds clouds;
	public int dt;
	public sys sys;
	public int timezone;
	public int id;
	public String name;
	public int cod;

	
	public objects() 
	{
		coord = new coord();
		main = new main();
		wind = new wind();
		clouds = new clouds();
		sys = new sys();
	}
	public class coord
	{
		public double lon;
		public double lat;
	}
	public class main
	{
		public float temp;
		public float feels_like;
		public float temp_min;
		public float temp_max;
		public int pressure;
		public int humidity;
		public int sea_level;
		public int grnd_level;
	}
	public class wind
	{
		public float speed;
		public int deg;
		public float gust;
	}
	public class clouds
	{
		public int all;
	}
	public class sys
	{
		public int id;
		public String country;
		public int type;
		public int sunrise;
		public int sunset;
	}

}
