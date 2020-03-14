package com.es2.composite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class CompositeTest {
    // Attributes
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    public void testAbstractMethod() throws NoSuchMethodException, SecurityException {
        assertTrue(Modifier.isAbstract(Menu.class.getDeclaredMethod("showOptions").getModifiers()));
    }

    @Test
    public void testAbstractClass() {
        assertTrue(Modifier.isAbstract(Menu.class.getModifiers()));
    }

    @Test
    public void testOutput() {
        System.setOut(new PrintStream(outContent));

        SubMenu m = new SubMenu();
        m.setLabel("Inserir");

        SubMenu client = new SubMenu();
        client.setLabel("Cliente");
        m.addChild(client);

        Link enterprise = new Link();
        enterprise.setLabel("Empresarial");

        enterprise.setURL("http://www.abc.pt/empresarial");
        client.addChild(enterprise);

        SubMenu particular = new SubMenu();
        particular.setLabel("Particular");
        client.addChild(particular);

        Link withVat = new Link();
        withVat.setLabel("Particular com contribuinte");
        withVat.setURL("http://www.abc.pt/pcc");
        particular.addChild(withVat);

        m.showOptions();

        String expected = "Inserir\nCliente\nEmpresarial\nhttp://www.abc.pt/empresarial\nParticular\nParticular com contribuinte\nhttp://www.abc.pt/pcc\n";

        assertEquals(expected, outContent.toString());

        System.setOut(originalOut);
    }
}
