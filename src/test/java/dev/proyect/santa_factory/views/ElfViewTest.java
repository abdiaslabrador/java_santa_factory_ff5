package dev.proyect.santa_factory.views;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.proyect.santa_factory.controllers.ToyController;
import dev.proyect.santa_factory.dtos.BadChildToyDto;
import dev.proyect.santa_factory.dtos.GoodChildToyDto;
import dev.proyect.santa_factory.models.BadChildToy;
import dev.proyect.santa_factory.models.GoodChildToy;

public class ElfViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Scanner scanner; 
    ToyController controller;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        controller = new ToyController();
    }

    @Test
    void testCreateBadToyInputs() {
        String simulatedInput = "spongebob toy\nwood\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        scanner = new Scanner(System.in);
        BadChildToyDto badChildToy = ElfView.createBadToyInputs(scanner);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Ingrese el título:"));
        assertTrue(output.contains("Ingrese contenido:"));
        assertThat("spongebob toy", is(badChildToy.title()));
        assertThat("wood", is(badChildToy.content()));
    }

    @Test
    void testCreateGoodToyInputs() {
        String simulatedInput = "spongebob toy\nlego\n3\nconstruction\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        scanner = new Scanner(System.in);
        GoodChildToyDto goodChildToy = ElfView.createGoodToyInputs(scanner);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Ingrese el título:"));
        assertTrue(output.contains("Ingrese la marca:"));
        assertTrue(output.contains("Ingrese la edad recomendada:"));
        assertTrue(output.contains("Ingrese la categoria:"));
        assertThat("spongebob toy", is(goodChildToy.title()));
        assertThat("lego", is(goodChildToy.brand()));
        assertThat(3, is(goodChildToy.recommendedAge()));
        assertThat("construction", is(goodChildToy.category()));
    }

    @Test
    void testIdToDeleteInput() {
        controller.postGoodChildToy(new GoodChildToy(1, "spongebob toy", "lego", 3, "construction"));        
        controller.postBadChildToy(new BadChildToy(1, "plastic mause", "plastic"));
        String simulatedInput = "M1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        scanner = new Scanner(System.in);
        ElfView.showToysToDelete(controller, scanner);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("B1. Titulo: spongebob toy"));
        assertTrue(output.contains("M1. Titulo: plastic mause"));
        assertTrue(output.contains("Ingrese el identificador del juguete a eliminar: "));
        assertTrue(output.contains("Juguete eliminado con éxito"));
    }

    @Test
    void testIdToDeleteInput_IdNotFound() {
        controller.postGoodChildToy(new GoodChildToy(1, "spongebob toy", "lego", 3, "construction"));        
        controller.postBadChildToy(new BadChildToy(1, "plastic mause", "plastic"));
        String simulatedInput = "M10000000\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        scanner = new Scanner(System.in);
        ElfView.showToysToDelete(controller, scanner);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Juguete no encontrado"));
    }

    @Test
    void testShowGoodAndBadToys() {
        controller.postGoodChildToy(new GoodChildToy(1, "spongebob toy", "lego", 3, "construction"));        
        controller.postBadChildToy(new BadChildToy(1, "plastic mause", "plastic"));
        ElfView.showGoodAndBadToys(controller);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("B1. Titulo: spongebob toy, Marca: lego, Edad: 3, Categoria: construction"));
        assertTrue(output.contains("M1. Titulo: plastic mause, Contenido: plastic"));
    }

    @Test
    void testShowMenu() {
        String simulatedInput = "1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        scanner = new Scanner(System.in);
        ElfView.showMenu(scanner);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("\nGestor de juguetes (Tipo de sesión: Elfo)"));
        assertTrue(output.contains("1. Añadir juguete"));
        assertTrue(output.contains("2. Ver todos los juguetes"));
        assertTrue(output.contains("3. Eliminar juguete"));
        assertTrue(output.contains("4. Cerrar sesión"));
        assertTrue(output.contains("Seleccione una opción: "));    
    }

    @Test
    void testShowToyAdded() {
        ElfView.showToyAdded();
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("\nJuguete añadido con éxito"));
    }

    @Test
    void testShowToyMenu() {
        String simulatedInput = "1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        scanner = new Scanner(System.in);
        ElfView.showToyMenu(scanner);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("\nPara niño ...:"));
        assertTrue(output.contains("1. Bueno"));
        assertTrue(output.contains("2. Malo"));
        assertTrue(output.contains("Seleccione una opción: "));
    }

    
}
