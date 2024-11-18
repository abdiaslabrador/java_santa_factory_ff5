package dev.proyect.santa_factory.views;

import java.util.List;

import dev.proyect.santa_factory.models.Toy;


public abstract class CloseSessionView extends View {
    public static void showCloseSession() {
        System.out.println("\nSesión cerrada correctamente.");
    }
    
    public static void showChidrenToys(List<? extends Toy> toys, String noToyMsg){
        if(toys.size() > 0 ){
            for (Toy toy : toys) {
                System.out.println(toy.toString());
            }
        }else{
            System.out.println(noToyMsg);
        }
    }
    
}
