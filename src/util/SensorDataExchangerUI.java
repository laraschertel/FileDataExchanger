package util;

import app.TCPDataExchangerImpl;
import app.TCPSensorDataExchanger;
import sensordata.SensorData;
import sensordata.SensorDataImpl;

import java.io.IOException;

public class SensorDataExchangerUI {
    public static void main(String[] args) throws IOException {

        String hostname = null;
        int port = -1;
        String portString = null;

        if(args.length == 2){ // variant 1: send
            hostname = args[0];
            portString = args[1];
        }else if(args.length == 1){ // variant 2: receive
            portString = args[0];

        }
        port = Integer.parseInt(portString);

        SensorData data = new SensorDataImpl(System.currentTimeMillis(), 37, "measurementSensor");

        TCPSensorDataExchanger tcpSensorDataExchanger = new TCPDataExchangerImpl();
        if(hostname == null){
            // receive
            tcpSensorDataExchanger.receiveSensorData(port);
        }else {
            // send
            tcpSensorDataExchanger.sendSensorData(data, hostname, port);
        }



    }
}
