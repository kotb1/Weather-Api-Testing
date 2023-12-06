package Contracts;

import Services.objects;

public interface IJsonService {
    public <T> T fromJson(String jsonString, Class<T> classOfT);

    public String toJson(objects object);
}
