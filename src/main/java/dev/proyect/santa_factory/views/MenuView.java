package dev.proyect.santa_factory.views;
import java.util.Scanner;

import dev.proyect.santa_factory.controllers.ToyController;

public class MenuView extends View {

    ToyController controller;

    public MenuView(ToyController controller) {
        this.controller = controller;
    }

    public void start(){
        while (true) {
            int selection = showMenu(scanner);
            if(selection == 1){
                ElfView.menu(controller);
            }
            else if(selection == 2){
                SantaView.menu(controller);
            }
            else if (selection == 3) {
                scanner.close();
                break;
            }
        }
    }
            
    public static int showMenu(Scanner scanner){
        int selection = 0;
        while(selection < 1 || selection > 3) {
            System.out.println("\nIniciar sesión de trabajo como:");
            System.out.println("1. Elfo");
            System.out.println("2. Santa Claus");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            selection = scanner.nextInt();
            scanner.nextLine();
        }
        return selection;
    }
}
