package Interfaces;

import java.io.IOException;

public interface IFileExchange {
    void copyFile(String filename)throws IOException;
    void readFile(String filename)throws IOException;

}
