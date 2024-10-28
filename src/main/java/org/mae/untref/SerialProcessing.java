package org.mae.untref;

import com.fazecast.jSerialComm.SerialPort;

import java.lang.ref.Cleaner;


public class SerialProcessing {

    SerialPort serialPort;
    private static final Cleaner cleaner = Cleaner.create();

    public SerialProcessing(String portName, Integer baudRate) {
        serialPort = SerialPort.getCommPort(portName);
        serialPort.setBaudRate(baudRate);
        if (serialPort.openPort()) {
            System.out.print("Puerto " + portName + " abierto correctamente");
            System.out.print(" | Port " + portName + " opened successfully");
        } else {
            System.out.print("No se pudo abrir el puerto " + portName);
            System.out.print(" | Port " + portName + " can't open");
        }
        cleaner.register(this, serialPort::closePort); // Cuando el objeto muere cierra el puerto
    }

    public void send(Package aPackage) {
        if(serialPort.writeBytes(aPackage.data(), aPackage.length()) > 0) {
            System.out.print("Datos enviados correctamente");
            System.out.print(" | Data sent successfully");
        };
    }
}
