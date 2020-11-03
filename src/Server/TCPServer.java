package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import Interfaces.IFileExchange;
import Interfaces.ISensordatenExchange;


public class TCPServer implements IFileExchange, ISensordatenExchange {
    private static long zeitpunkt;
    private static float sensorwert;
    private static String sensorname;
    private final int port;
    public static final int PORTNUMBER = 3232;


    public static void main(String[] args) throws IOException, InterruptedException {

        TCPServer tcpServer = new TCPServer(PORTNUMBER);

        if(args.length == 1){
            tcpServer.readFile(args[0]);
        }else {
            tcpServer.sensordatumReceive();

        }
    }

    @Override
    public void copyFile(String filename) {

    }

    public void readFile(String filename) throws IOException {
        Socket socket = this.acceptSocket();
        FileOutputStream fos = new FileOutputStream(filename);
        InputStream is = socket.getInputStream();

        int read = 0;
        do{
            read = is.read();
            if(read != -1){
                fos.write(read);
            }
        }while(read != -1);


    }



    public void sensordatumReceive() throws IOException {

        Socket socket = this.acceptSocket();
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        this.zeitpunkt = dis.readLong();
        this.sensorwert = dis.readFloat();
        this.sensorname = dis.readUTF();
        System.out.println("Zeitpunkt = " + zeitpunkt + ", Sensorwert = " + sensorwert + " und Sensorname = " + sensorname);
    }
    @Override
    public void sensordatumSend(long zeitpunkt, float sensorwert, String sensorname) throws IOException {



    }

    TCPServer(int port){
        this.port = port;
    }

    public Socket acceptSocket() throws IOException {
        ServerSocket srvSocket = new ServerSocket(this.port);
        System.out.println("server socket created");
        return srvSocket.accept();

    }


    private void connect() throws IOException, InterruptedException {

      Socket socket = this.acceptSocket();

        System.out.println("received");


       Thread.sleep(500);
        System.out.println("woke up");

    }



}