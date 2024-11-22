package dev.proyect.santa_factory.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BadChildToyTest {

    BadChildToy toy;

    @BeforeEach
    public void setUp() {
        toy = new BadChildToy(1, "spongebob toy", "rocks");
    }

    @Test
    void testGetContent() {
        assertThat("rocks", is(toy.getContent()));
    }

    @Test
    void testSetContent() {
        String newContent = "wood";
        assertThat("rocks", is(toy.getContent()));
        toy.setContent(newContent);
        assertThat(newContent, is(toy.getContent()));
    }

    @Test
    void testToString() {
        String toyToString = "M1" + 
        ". Titulo: " + "spongebob toy" + 
        ", Contenido: " + "rocks";
        assertThat(toyToString, is(toy.toString()));
    }
}
