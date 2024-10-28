package org.mae.untref;

import com.fazecast.jSerialComm.SerialPort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class SerialProcessingTest {

    private static SerialPort mockSerialPort;

    @BeforeAll
    public static void init() {
        mockStatic(SerialPort.class); // Mockea los métodos estáticos de SerialPort
        mockSerialPort = mock(SerialPort.class);
        when(SerialPort.getCommPort("COM3")).thenReturn(mockSerialPort);
        when(mockSerialPort.openPort()).thenReturn(true);
    }

    @Test
    public void  shouldSendPackage() {
        // Dada una instancia de SerialUntref y un paquete a enviar
        SerialProcessing serial = new SerialProcessing("COM3", 9600);
        Package aPackage = new Package();
        aPackage.add(true);

        // Cuando envío el paquete
        serial.send(aPackage);

        // Entonces se invoca a writeBytes
        byte[] expectedBytes = new byte[] { 1 }; // Asume que `true` se envía como 1 en byte
        verify(mockSerialPort).writeBytes(eq(expectedBytes), eq(expectedBytes.length));
    }
}
