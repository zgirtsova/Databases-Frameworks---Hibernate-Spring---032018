package org.softuni.mostwanted.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.softuni.mostwanted.io.interfaces.FileIO;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.parser.exeptions.SerializeExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Component(value = "JSONParser")
public class JSONParser implements Parser {

    private Gson gson;

    @Autowired
    private FileIO fileIO;

    public JSONParser() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public <T> T read(Class<T> objectClass, String file) throws IOException {
        String jsonContent = this.fileIO.read(file);
        T object = this.gson.fromJson(jsonContent, objectClass);
        return object;
    }

    @Override
    public <T> void write(T object, String file) throws IOException {
        String jsonContent = this.gson.toJson(object);
        this.fileIO.write(jsonContent, file);
    }

    // взето от лекцията на И.Наскинова за XML/JSON
    @Override
    public <T> T importFromFile(Class<T> classObj, String fileName) {

        try {
            String path = System.getProperty("user.dir") + PERSON_INPUT_DIRECTORY + fileName;
            System.out.println("File path: " + path);

            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            T importFromJsonDTO = gson.fromJson(bufferedReader, classObj);
            return importFromJsonDTO;
        } catch (IOException e) {
            e.printStackTrace();
            throw new SerializeExeption(fileName
                    + " cannot be read and nothing is deserialized to "
                    + fileName + ".\n"
                    + "Message: " + e.getMessage() + ".\n"
                    + "Cause: " + e.getCause() + ".\n", e);
        }
    }

    // взето от лекцията на И.Наскинова за XML/JSON
    @Override
    public <T> void exportToFile(T t, String fileName) {

        String path = System.getProperty("user.dir") + PERSON_OUTPUT_DIRECTORY + fileName;

        System.out.println("File path: " + path);
        try {
            FileWriter writer = new FileWriter(path);

            writer.write(gson.toJson(t));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new SerializeExeption(t.toString() + " cannot be written " +
            "and nothing is serialized to " + fileName + ".\n" +
            "Message: " + e.getMessage() + ".\n" +
            "Cause: " + e.getCause() + ".\n", e);
        }
    }

    private static final String PERSON_OUTPUT_DIRECTORY = "/src/main/resources/files/json/output/";
    private static final String PERSON_INPUT_DIRECTORY = "/src/main/resources/files/json/input/";


}
