import java.io.*;

public class FileStreams {

    public static void main(String[] args) {

        String filename = "textFile.txt";
        String someText = "Hallo";
        byte[] textAsByte = someText.getBytes();
        try {
            OutputStream os = new FileOutputStream(filename);
            try {
                os.write(textAsByte);
            } catch (IOException ex) {
                System.err.println("couldn’t write data - fatal");
                System.exit(0);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Could not open file - fatal");
            System.exit(0);
        }

        InputStream is = null;
        try {
            is = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn't open file - fatal");
            System.exit(0);
        }

        byte[] readBuffer = new byte[100];
        try {
            is.read(readBuffer);
        } catch (IOException ex) {
            System.err.println("couldn't read data - fatal");
            System.exit(0);
        }

        String readString = new String(readBuffer);
        System.out.println("read something: " + readString);


    }
}
