package dev.proyect.santa_factory.controllers;
import dev.proyect.santa_factory.repositories.GoodToyRepository;
import dev.proyect.santa_factory.repositories.BadToyRepository;
import dev.proyect.santa_factory.models.BadChildToy;
import dev.proyect.santa_factory.models.GoodChildToy;

import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class ToyController {

    private GoodToyRepository goodToyRepository;
    private BadToyRepository badToyRepository;

    public ToyController(){
        goodToyRepository = new GoodToyRepository();
        badToyRepository = new BadToyRepository();
    }
    
    public void postGoodChildToy(GoodChildToy gChildToy){
        goodToyRepository.save(gChildToy);
    }

    public void postBadChildToy(BadChildToy bChildToy){
        badToyRepository.save(bChildToy);
       
    }

    public List<GoodChildToy> getGoodChildrenToys(){
        return goodToyRepository.getAll();
    }

    public List<BadChildToy> getBadChildrenToys(){
        return badToyRepository.getAll();
    }

    public boolean deleteChildrenToy(String id){
        if (badToyRepository.delete(id) || goodToyRepository.delete(id)) return true;
        return false;
    }

    public void generateCsv(){
        try(Writer writer = new FileWriter("goodChidrenToys.csv")){
            StatefulBeanToCsv<GoodChildToy> beanToCsv = new StatefulBeanToCsvBuilder<GoodChildToy>(writer).withSeparator(',').withApplyQuotesToAll(false).build();
            beanToCsv.write(goodToyRepository.getAll());
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrió un error al escribir el archivo: " + e.getMessage());
        }

        try(Writer writer = new FileWriter("badChildrenToys.csv")){
            StatefulBeanToCsv<BadChildToy> beanToCsv2 = new StatefulBeanToCsvBuilder<BadChildToy>(writer).withSeparator(',').withApplyQuotesToAll(false).build();
            beanToCsv2.write(badToyRepository.getAll());
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrió un error al escribir el archivo: " + e.getMessage());
        }

        System.out.println("\nLista de juguetes guardada.");
    }
}
