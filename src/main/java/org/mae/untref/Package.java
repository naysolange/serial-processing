package org.mae.untref;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Package {

    private final ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

    public void add(Integer i) {
        try {
            byteStream.write(ByteBuffer.allocate(4).putInt(i).array());
        } catch(IOException e) {
            System.out.print("No se pudo agregar dato " + i);
            System.out.print(" | Can't add " + i + " data");
        }
    }

    public void add(Float f) {
        try {
            byteStream.write(ByteBuffer.allocate(4).putFloat(f).array());
        } catch(IOException e) {
            System.out.print("No se pudo agregar dato " + f);
            System.out.print(" | Can't add " + f + " data");
        }
    }

    public void add(Boolean b) {
        byteStream.write(b ? 1 : 0);
    }

    public void add(String s) {
        try {
            byte[] stringBytes = s.getBytes(StandardCharsets.UTF_8); // Por defecto uso UTF-8, se podría parametrizar
            byteStream.write(stringBytes);
        } catch(IOException e) {
            System.out.print("No se pudo agregar dato " + s);
            System.out.print(" | Can't add " + s + " data");
        }
    }

    public void add(Character c) {
        try {
            byteStream.write(ByteBuffer.allocate(2).putChar(c).array());
        } catch(IOException e) {
            System.out.print("No se pudo agregar dato " + c);
            System.out.print(" | Can't add " + c + " data");
        }
    }

    protected byte[] data() {
        return byteStream.toByteArray();
    }

    protected int length() {
        return byteStream.toByteArray().length;
    }
}
