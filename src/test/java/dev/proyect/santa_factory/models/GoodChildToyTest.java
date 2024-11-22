package dev.proyect.santa_factory.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GoodChildToyTest {

    GoodChildToy toy;

    @BeforeEach
    public void setUp() {
        toy = new GoodChildToy(1, "spongebob toy", "lego", 3, "construction");
    }

    @Test
    void testGetBrand() {
        assertThat("lego", is(toy.getBrand()));
    }

    @Test
    void testGetCategory() {
        assertThat("construction", is(toy.getCategory()));
    }

    @Test
    void testGetRecommendAge() {
        assertThat(3, is(toy.getRecommendAge()));
    }

    @Test
    void testSetBrand() {
        String newBrand = "mattel";
        assertThat("lego", is(toy.getBrand()));
        toy.setBrand(newBrand);
        assertThat(newBrand, is(toy.getBrand()));
    }

    @Test
    void testSetCategory() {
        String newCategory = "jugle";
        assertThat("construction", is(toy.getCategory()));
        toy.setCategory(newCategory);
        assertThat(newCategory, is(toy.getCategory()));
    }

    @Test
    void testSetRecommendAge() {
        int newRecommendAge = 18;
        assertThat(3, is(toy.getRecommendAge()));
        toy.setRecommendAge(newRecommendAge);
        assertThat(newRecommendAge, is(toy.getRecommendAge()));
    }

    @Test
    void testToString() {
        String toyToString = "B1"+". " + 
        "Titulo: " + "spongebob toy" + 
        ", Marca: " + "lego" +
        ", Edad: " + 3 + 
        ", Categoria: " + "construction";
        assertThat(toyToString, is(toy.toString()));
    }
}
