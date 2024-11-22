package dev.proyect.santa_factory.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.opencsv.CSVReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.FileReader;
import java.io.IOException;

import dev.proyect.santa_factory.models.BadChildToy;
import dev.proyect.santa_factory.models.GoodChildToy;

public class ToyControllerTest {

    ToyController controller;

    @BeforeEach
    public void setUp() {
        controller = new ToyController();
    }

    @Test
    void testDeleteGoodChildrenToy_goodToy() {       
        controller.postGoodChildToy(new GoodChildToy( "spongebob toy", "lego", 3, "construction"));        
        assertThat(true, is(controller.deleteChildrenToy("B1")));
    }

    @Test
    void testDeleteBadChildrenToy() {       
        controller.postBadChildToy(new BadChildToy( "spongebob toy", "wood"));        
        assertThat(true, is(controller.deleteChildrenToy("M1")));
    }

    @Test
    void testPostBadChildToy() {
        BadChildToy badChildToy = new BadChildToy("spongebob toy", "wood");
        controller.postBadChildToy(badChildToy);
        assertThat(true, is(controller.getBadChildrenToys().contains(badChildToy)));
    }

    @Test
    void testPostGoodChildToy() {
        GoodChildToy goodChildToy = new GoodChildToy("spongebob toy", "lego", 3, "construction");
        controller.postGoodChildToy(goodChildToy);
        assertThat(true, is(controller.getGoodChildrenToys().contains(goodChildToy))); 
    }

    @Test
    void testGenerateCsv() {
        String goodChildrenToysFileName = "goodChidrenToys.csv";
        String badChildrenToysFileName = "badChildrenToys.csv";
        controller.postGoodChildToy(new GoodChildToy( "spongebob toy", "lego", 3, "construction"));        
        controller.postBadChildToy(new BadChildToy( "spongebob toy", "wood"));        
        controller.generateCsv();

        assertThat(true, is(esArchivoOpenCSV(goodChildrenToysFileName))); 
        assertThat(true, is(esArchivoOpenCSV(badChildrenToysFileName))); 
    }


    public boolean esArchivoOpenCSV(String rutaArchivo) {
        try (CSVReader csvReader = new CSVReader(new FileReader(rutaArchivo))) {
            try {
                while ((csvReader.readNext()) != null) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
            
        } catch (IOException e) {
            return false;
        }
        return false;
    }
}
