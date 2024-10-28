package org.mae.untref;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;


public class PackageTest {

    @Test
    public void shouldCreateAPackageWithAString() {
        // Dado un string a agregar al paquete
        String input = "hello";
        Package p = new Package();
        p.add(input);

        // Cuando obtengo el string que viene en la data
        byte[] data = p.data();
        String obtained = new String(data, StandardCharsets.UTF_8);

        // Entonces obtengo un array de bytes que representa mi input
        Assertions.assertEquals(input, obtained);
    }

    @Test
    public void shouldCreateAPackageWithAInteger() {
        // Dado un entero a agregar al paquete
        Integer input = Integer.MAX_VALUE;
        Package p = new Package();
        p.add(input);

        // Cuando obtengo el entero que viene en la data
        byte[] data = p.data();
        int obtained = ByteBuffer.wrap(data).getInt();

        // Entonces obtengo un array de bytes que representa mi input
        Assertions.assertEquals(input, obtained);
    }

    @Test
    public void shouldCreateAPackageWithAFloat() {
        // Dado un flotante a agregar al paquete
        Float input = Float.MAX_VALUE;
        Package p = new Package();
        p.add(input);

        // Cuando obtengo el flotante que viene en la data
        byte[] data = p.data();
        float obtained = ByteBuffer.wrap(data).getFloat();

        // Entonces obtengo un array de bytes que representa mi input
        Assertions.assertEquals(input, obtained);
    }

    @Test
    public void shouldCreateAPackageWithACharacter() {
        // Dado un caracter a agregar al paquete
        Character input = 'Z';
        Package p = new Package();
        p.add(input);

        // Cuando obtengo el caracter que viene en la data
        byte[] data = p.data();
        Character obtained = ByteBuffer.wrap(data).getChar();

        // Entonces obtengo un array de bytes que representa mi input
        Assertions.assertEquals(input, obtained);
    }

    @Test
    public void shouldCreateAPackageWithABoolean() {
        // Dado un booleano a agregar al paquete
        boolean input = false;
        Package p = new Package();
        p.add(input);

        // Cuando obtengo el booleando que viene en la data
        byte[] data = p.data();
        boolean obtained = data.length > 0 && data[0] != 0;

        // Entonces obtengo un array de bytes que representa mi input
        Assertions.assertEquals(input, obtained);
    }
}
