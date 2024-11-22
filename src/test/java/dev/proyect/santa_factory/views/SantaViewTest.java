package dev.proyect.santa_factory.views;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.proyect.santa_factory.controllers.ToyController;
import dev.proyect.santa_factory.models.GoodChildToy;

public class SantaViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Scanner scanner; 
    ToyController controller;


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        controller = new ToyController();
    }

    @Test
    void testShowMenu() {
        String simulatedInput = "1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        scanner = new Scanner(System.in);
        SantaView.showMenu(scanner);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("1. Ver lista de juguetes niños buenos"));
        assertTrue(output.contains("2. Ver lista de juguetes niños malos"));
        assertTrue(output.contains("3. Guargar lista de todos los juguetes (.csv)"));
        assertTrue(output.contains("4. Cerrar sesión"));
        assertTrue(output.contains("Seleccione una opción: "));
    }

    @Test
    void testShowCloseSession() {
        SantaView.showCloseSession();
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("\nSesión cerrada correctamente."));
    }

    @Test
    void testShowChildrenToys() {
        controller.postGoodChildToy(new GoodChildToy(1, "spongebob toy", "lego", 3, "construction"));        
        SantaView.showChildrenToys(controller.getGoodChildrenToys(), "No hay juguetes");
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("B1. Titulo: spongebob toy, Marca: lego, Edad: 3, Categoria: construction"));
    }

    @Test
    void testShowNoToyMessage() {
        List<GoodChildToy> goodChidrenToys = new ArrayList<>();
        SantaView.showChildrenToys(goodChidrenToys, "No hay juguetes");
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("No hay juguetes"));
    }
}
