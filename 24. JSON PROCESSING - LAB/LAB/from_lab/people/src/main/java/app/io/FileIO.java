package app.io;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileIO {

    public String read(String fileName) throws IOException {
        StringBuilder fileContent = new StringBuilder();

        try(InputStream is = getClass().getResourceAsStream(fileName);
            BufferedReader bfr = new BufferedReader(new InputStreamReader(is))
        ) {
            String line = null;
            while ((line = bfr.readLine()) != null) {
                fileContent.append(line);
            }
        }

        return fileContent.toString();
    }

    //public void write(String content, String fileName)
}
