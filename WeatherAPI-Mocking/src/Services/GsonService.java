package Services;

import com.google.gson.Gson;

import Contracts.IJsonService;
import Contracts.IWeatherService;

public class GsonService implements IJsonService {
    private static Gson gson = new Gson();
    //public objects o = new objects();
    public objects o;

    /*public GsonService() 
    {
    	o=new objects();
    }*/
    @Override
    public <T> T fromJson(String jsonString, Class<T> classOfT) {
        // TODO Auto-generated method stub
    	o=new objects(); 
    	o=gson.fromJson(jsonString, objects.class);
        /*System.out.println(o.main.temp);
        System.out.println(o.coord.lon);
        System.out.println(o.base);
        System.out.println(o.visibility);
        System.out.println(o.sys.country);*/
        //o=gson.fromJson(jsonString,IWeatherService.class);
        return (T)o;
        
        //return (T) o.base;
    }

    @Override
    public String toJson(objects object) {
        // TODO Auto-generated method stub
    	String response = "The coordinates are: longitude = "+object.coord.lon+" ,latitude = "+object.coord.lat+"\n"
        +"Base = "+object.base+"\n"
        +"The main are: Temperature = "+object.main.temp+" ,Feels_like = "+object.main.feels_like+
        " ,Temperature_min = "+object.main.temp_min+" ,Temperature_max = "+object.main.temp_max
        +" ,Pressure = "+object.main.pressure+" ,Humidity = "+object.main.humidity+" ,Sea_level = "+object.main.sea_level
        +" ,Ground_level = "+object.main.grnd_level+"\n"
        +"Visibility = "+object.visibility+"\n"
        +"The Wind Properties are: Speed = "+object.wind.speed+" ,deg = "+object.wind.deg+" ,gust = "+object.wind.gust+"\n"
        +"The Clouds Properties are: All = "+object.clouds.all+"\n"
        +"DT = "+object.dt+"\n"
        +"The System Properties are: Type = "+object.sys.type+" ,ID = "+object.sys.id+" ,country = "+object.sys.country+" ,sunrise"+object.sys.sunrise+" ,sunset"+object.sys.sunset+"\n"
        +"TimeZone = "+object.timezone+"\n"
        +"ID = "+object.id+"\n"
        +"Name = "+object.name+"\n"
    	+"COD = "+object.cod;
        return response;
    }

}
