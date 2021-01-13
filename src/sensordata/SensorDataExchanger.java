package sensordata;

import java.io.*;
import java.util.Date;

public class SensorDataExchanger implements SensorDataSender, SensorDataReceiver{
    @Override
    public void sendSensorData(SensorData data, OutputStream os) throws IOException {
        DataOutputStream dos = new DataOutputStream(os);

        dos.writeLong(data.getTimeStamp());
        dos.writeFloat(data.getValue());
        dos.writeUTF(data.getSensorName());

        os.close();

    }

    @Override
    public SensorData receiveSensorData(InputStream is) throws IOException {

        DataInputStream dis = new DataInputStream(is);

        long timeStamp = dis.readLong();
        float value = dis.readFloat();
        String sensorName = dis.readUTF();

        Date date = new Date(timeStamp);

        System.out.println("Zeitpunkt = " + date + ", Sensorwert = " + value + " und Sensorname = " + sensorName);

        return new SensorDataImpl(timeStamp, value, sensorName);

    }


}
