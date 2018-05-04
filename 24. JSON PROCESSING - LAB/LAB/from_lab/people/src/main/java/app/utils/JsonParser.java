package app.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

@Component
public class JsonParser {

    private Gson gson;

    public JsonParser() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // get an Object of desired class from json String path
    public <T> T getFromFile(Class<T> tClass, String path) {
        return this.gson.fromJson(TextFileUtils.read(path), tClass);
    }

    // get an Object of desired class from json String
    public <T> T getFromJson(Class<T> tClass, String json) {
        return this.gson.fromJson(json, tClass);
    }

    public <T> void writeToFile(T obj, String path) {
        TextFileUtils.write(toJson(obj), path);
    }

    public <T> String toJson(T obj) {
        return this.gson.toJson(obj);
    }
}

