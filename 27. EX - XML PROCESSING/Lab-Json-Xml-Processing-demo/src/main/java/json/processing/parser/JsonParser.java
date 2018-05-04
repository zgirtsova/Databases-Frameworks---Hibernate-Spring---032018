package json.processing.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import json.processing.io.FileIOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import json.processing.parser.exeptions.*;

import java.io.File;
import java.io.IOException;

@Component(value = "JsonParser")
public class JsonParser implements Parser {

    private Gson gson;

    @Autowired
    private FileIOImpl fileIO;

    public JsonParser() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public <T> void serialize(T t, String fileName) {
        String path = System.getProperty("user.dir") + File.separator + fileName;
        String json = gson.toJson(t);
        try {
            File f = new File(path);
            if (!f.exists()){
                //getParentFile -> взима пътя до преди input/output.
                // mkdirs() -> създава директорийте които не съществуват
                f.getParentFile().mkdirs();
                f.createNewFile();
            }

            fileIO.write(json, fileName);
        } catch (IOException e) {
            //log here..
            throw new SerializeExeption(json + "was not serialised to " + path, e);
        }
    }

    @Override
    public <T> T deserialize(Class<T> clazz, String fileName) {

        try {
            String json = fileIO.read(fileName);
            return gson.fromJson(json, clazz);
        } catch (IOException e) {
            //log here...
            throw new SerializeExeption(fileName + "cannot be read!", e );
        }
    }
}
