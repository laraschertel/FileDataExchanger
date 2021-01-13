package fileexchange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public interface FileSender {
    /**
     * Send file from a local program over an output stream to maybe another process
     * @param filename local file name
     * @param os connection/ stream to ermote entity
     */
    void sendFile(String filename, OutputStream os) throws IOException;

}
