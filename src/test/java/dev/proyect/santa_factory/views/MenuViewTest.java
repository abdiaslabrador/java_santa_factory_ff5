package dev.proyect.santa_factory.views;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.proyect.santa_factory.controllers.ToyController;

public class MenuViewTest {
    
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    ToyController controller;
    private Scanner scanner; 

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));       
        MenuView menu = new MenuView(controller);
    }

    @Test
    void testShowMenu() {
        String simulatedInput = "1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        scanner = new Scanner(System.in);
        MenuView.showMenu(scanner);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("\nIniciar sesión de trabajo como:"));
        assertTrue(output.contains("1. Elfo"));
        assertTrue(output.contains("2. Santa Claus"));
        assertTrue(output.contains("3. Salir"));
        assertTrue(output.contains("Seleccione una opción: "));
    }
}
