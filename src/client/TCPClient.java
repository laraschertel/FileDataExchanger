package client;

import java.io.*;
import java.net.Socket;
import Interfaces.IFileExchange;
import Interfaces.ISensordatenExchange;


public class TCPClient implements IFileExchange, ISensordatenExchange {
        private final int port;
        private final String hostname;


        public static void main(String[] args) throws IOException {
            if(args.length < 2){
                System.out.println("missing parameters: <hostname> <portnumber>");
            }

            String hostname = args[0];
            String portString = args[1];
            String filename = null;


            if(args.length > 2){
                filename = args[2];
            }


            int portnumber =  Integer.parseInt(portString);

            TCPClient tcpClient = new TCPClient(hostname, portnumber);

            if(filename != null){
                tcpClient.copyFile(filename);
            }else {
                long zeitpunkt = System.currentTimeMillis();
                float sensorwert = 37;
                String sensorname = "Temperatura";
               tcpClient.sensordatumSend(zeitpunkt, sensorwert, sensorname);

            }
        }
    public void copyFile(String filename) throws IOException {
        Socket socket = new Socket(this.hostname, this.port);

        FileInputStream fis = new FileInputStream(filename);
        OutputStream os = socket.getOutputStream();

        int read = 0;
        do {
            read = fis.read();
            if(read != -1){
                os.write(read);
            }
        }while(read != -1);
        os.close();

        System.out.println("File was sent");
    }

    @Override
    public void readFile(String filename) throws IOException {

    }


    public void sensordatumSend(long zeitpunkt, float sensorwert, String sensorname) throws IOException {
        Socket socket = new Socket(this.hostname, this.port);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeLong(zeitpunkt);
        dos.writeFloat(sensorwert);
        dos.writeUTF(sensorname);

        dos.close();
        os.close();
    }
    public void sensordatumReceive() throws IOException{


    }

    TCPClient(String name, int port) {
            this.port = port;
            this.hostname = name;
        }


            private void connect() throws IOException {

                Socket socket = new Socket(hostname, port);
                System.out.println("socket created");



            }


            }