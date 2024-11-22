package dev.proyect.santa_factory.views;

import java.util.List;
import java.util.Scanner;

import dev.proyect.santa_factory.controllers.ToyController;
import dev.proyect.santa_factory.models.Toy;


public abstract class SessionView extends View {
    public static void showCloseSession() {
        System.out.println("\nSesión cerrada correctamente.");
    }
    
    public static void showChildrenToys(List<? extends Toy> toys, String noToyMsg){
        if(toys.size() > 0 ){
            for (Toy toy : toys) {
                System.out.println(toy.toString());
            }
        }else{
            System.out.println(noToyMsg);
        }
    }
    
    public static  int showMenu(Scanner scanner){
        return 0;
    };

    public static void menu(ToyController controller){
        System.out.println("muestra el menu");
    };
}
