package app.serialize;


import app.io.FileIO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component(value = "JSONSerializer")
public class JSONSerializer implements Serializer{

    private Gson gson;
    private FileIO fileIO;

    public JSONSerializer() {
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        fileIO = new FileIO();
    }


    @Override
    public <T> void serialize(T t, String fileName) {
        String json = gson.toJson(t);
        writeFileJSON(json, fileName);
    }

    @Override
    public <T> T deserialize(Class<T> t, String fileName) {

        try {
            String json = fileIO.read(fileName);
            return gson.fromJson(json, t);
        } catch (IOException e) {
            e.printStackTrace();
          //  throw new SerializeException(fileName + "cannot be read and nothing is");
        }
        return null;

    }

    public <T> List<T> importJSONList(Class<T> tClass, String fileName) throws IOException {
        Type type = new TypeToken<ArrayList<T>>() {
        }.getType();
        String file = this.fileIO.read(fileName);
        return this.gson.fromJson(file,type);
    }

    public void writeFileJSON(String json, String fileName) {

        String path = System.getProperty("user_dir") + File.separator + fileName;
        File f = new File(path);
        if (!f.exists()) {
            f.getParentFile().mkdirs();
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        try (OutputStream os = new FileOutputStream(fileName);
//             BufferedReader bfw = new BufferedReader(os));

    }
}
