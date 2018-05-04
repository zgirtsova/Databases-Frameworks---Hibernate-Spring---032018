package json.processing.io;

import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.nio.charset.Charset;

@Component
public class FileIOImpl implements FileIO {

    @Override
    public String read (String fileName) throws IOException {
        StringBuilder builder = new StringBuilder();
        InputStream inputStream = this.getClass().getResourceAsStream(fileName);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                //Log here..
            }
        }

        return builder.toString();
    }

    public void write (String content, String fileName) throws IOException {
        OutputStream outputStream = new FileOutputStream(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(content);
            writer.flush();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                //log here...
            }
        }
    }


    //got it from lecture
    public String readAllData(String fileName) {
        InputStream inputStream = Reader.class.getResourceAsStream(fileName);
        try {
            return StreamUtils.copyToString(inputStream, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //got it from lecture
    public void writeToFile(String source, String fileName) {
        try {
            String mainPath = System.getProperty("user.dir") + "/src/main/resources";
            FileWriter writer = new FileWriter(new File(mainPath + fileName));
            writer.write(source);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
