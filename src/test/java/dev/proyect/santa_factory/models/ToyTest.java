package dev.proyect.santa_factory.models;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToyTest {

    Toy toy;

    @BeforeEach
    public void setUp() {
        toy = new BadChildToy(1, "spongebob toy", "wood");
    }

    @Test
    void testGetId() {
        assertThat("M1", is(toy.getId()));
    }

    @Test
    void testGetTitle() {
        assertThat("spongebob toy", is(toy.getTitle()));
    }

    @Test
    void testIsGoodToy() {
        assertThat(false, is(toy.isGoodToy()));
    }

    @Test
    void testSetGoodToy() {
        boolean newIsGoodToyValue = true;
        assertThat(false, is(toy.isGoodToy()));
        toy.setGoodToy(newIsGoodToyValue);
        assertThat(newIsGoodToyValue, is(toy.isGoodToy()));
    }

    @Test
    void testSetId() {
        int newId = 2;
        assertThat("M1", is(toy.getId()));
        toy.setId(newId);
        assertThat("M"+newId, is(toy.getId()));
    }

    @Test
    void testSetTitle() {
        String newTitle = "patrick start";
        assertThat("spongebob toy", is(toy.getTitle()));
        toy.setTitle(newTitle);
        assertThat(newTitle, is(toy.getTitle()));
    }
}
