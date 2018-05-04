package json.processing.io;

import java.io.IOException;

public interface FileIO {

    String read(String file) throws IOException;

    //void write (String content, String fileName);
}
