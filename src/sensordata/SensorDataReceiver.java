package sensordata;

import java.io.IOException;
import java.io.InputStream;

public interface SensorDataReceiver {
    /**
     * Recceive data from input and create new sensor data object
     * @param is
     * @return
     */
    SensorData receiveSensorData(InputStream is) throws IOException;
}
