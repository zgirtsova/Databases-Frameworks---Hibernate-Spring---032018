package json.processing.parser;

public interface Parser {

    <T> void serialize (T t, String fileName);

    <T> T deserialize(Class<T> clazz, String fileName );
}
