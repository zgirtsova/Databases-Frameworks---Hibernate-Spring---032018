package ex.parser.api;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface Parser {

    <T> T read(Class<T> objectClass, String file) throws IOException, JAXBException;

    <T> void write(T object, String file) throws IOException, JAXBException;

    // взето от лекцията на И.Наскинова за XML/JSON
    <T> void exportToFile(T t, String fileName);

    // взето от лекцията на И.Наскинова за XML/JSON
    <T> T importFromFile(Class<T> classObj, String fileName);
}
