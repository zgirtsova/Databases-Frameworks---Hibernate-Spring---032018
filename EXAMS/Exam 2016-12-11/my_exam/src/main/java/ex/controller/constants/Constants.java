package ex.controller.constants;

public class Constants {

    public static final String JSON_INPUT_DIRECTORY = "/src/main/recources/files/json/input";
    public static final String JSON_OUTPUT_DIRECTORY = "/src/main/recources/files/json/output";
    public static final String XML_INPUT_DIRECTORY = "/src/main/recources/files/xml/input";

    public static String input_path = System.getProperty("user.dir") + JSON_INPUT_DIRECTORY;
    public static String output_path = System.getProperty("user.dir") + JSON_OUTPUT_DIRECTORY;

    public static final String input_camera_json = "/files/json/input/cameras.json";
    public static final String input_lenses_json = "/files/json/input/lenses.json";
    public static final String input_photographers_json = "/files/json/input/photographers.json";

}
