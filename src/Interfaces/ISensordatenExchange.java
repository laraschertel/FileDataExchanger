package Interfaces;

import java.io.IOException;

public interface ISensordatenExchange {
    void sensordatumSend(long zeitpunkt, float sensorwert, String sensorname) throws IOException;
    void sensordatumReceive() throws IOException;
}
