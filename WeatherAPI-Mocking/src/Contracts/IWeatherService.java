package Contracts;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface IWeatherService {
    public String getCurrentWeather(String cityName) throws ExecutionException;

    public String getCurrentWeather(int cityId) throws ExecutionException;

    public String getCurrentWeather(float latitude, float longitude) throws ExecutionException;
}
