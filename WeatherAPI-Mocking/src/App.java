import Contracts.IJsonService;
import Services.ApplicationService;
import Services.GsonService;
import Services.WeatherService;
import Services.objects;

public class App {

    public static void main(String[] args) throws Exception {
        var application = new ApplicationService(new WeatherService(), new GsonService());
        float lat = (float) 51.5085;
		float lon = (float) -0.1257;
        System.out.println(application.getCurrentWeather("London"));
        //System.out.println(application.getCurrentWeather(360630));
      //System.out.println(application.getCurrentWeather(lat,lon));
    }
}
