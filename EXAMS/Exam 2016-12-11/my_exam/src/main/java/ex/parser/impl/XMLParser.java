package ex.parser.impl;

import ex.parser.exeptions.SerializeExeption;
import ex.parser.api.Parser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

@Component(value = "XMLParser")
public class XMLParser implements Parser {

    private JAXBContext jaxbContext;

    @Override
    public <T> T read(Class<T> objectClass, String file) throws IOException, JAXBException {
        this.jaxbContext = JAXBContext.newInstance(objectClass);
        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
        T object;
        try (
                InputStream inputStream = getClass().getResourceAsStream(file);
        ) {
            object = (T) unmarshaller.unmarshal(inputStream);
        }

        return object;
    }

    @Override
    public <T> void write(T object, String file) throws IOException, JAXBException {
        this.jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = this.jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try (
                OutputStream outputStream = new FileOutputStream(file);
        ) {
            marshaller.marshal(object, outputStream);
        }
    }


    // serialization
    @Override
    public <T> void exportToFile(T t, String fileName) {
        JAXBContext jaxbContext = null;
        String path = System.getProperty("user.dir") + PERSON_OUTPUT_DIRECTORY + fileName;
        try {

            FileWriter writer = new FileWriter(path);

            jaxbContext = JAXBContext.newInstance(t.getClass());

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.marshal(t, writer);
                    // new FileOutputStream(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // deserialization
    @Override
    public <T> T importFromFile(Class<T> classObj, String fileName) {

        String path = System.getProperty("user.dir") + PERSON_INPUT_DIRECTORY + fileName;
        try {
            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(classObj);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            T importFromFileDTO = (T)unmarshaller.unmarshal(file);
            return importFromFileDTO;

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SerializeExeption e) {
            System.out.println("Error: " + e.getCause());
        }
        return null;
    }

    private static final String PERSON_OUTPUT_DIRECTORY = "/src/main/resources/files/xml/output/";
    private static final String PERSON_INPUT_DIRECTORY = "/src/main/resources/files/xml/input/";

}
