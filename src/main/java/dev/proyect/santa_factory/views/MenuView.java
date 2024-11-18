package dev.proyect.santa_factory.views;
import dev.proyect.santa_factory.controllers.ToyController;

public class MenuView extends View {

    ToyController controller;
    ElfView elfView;
    SantaView sataView;

    public MenuView(ToyController controller, ElfView elfView, SantaView sataView) {
        this.controller = controller;
        this.elfView = elfView;
        this.sataView = sataView;
    }

    public void start(){
        while (true) {
            int selection = showMenu();
            if(selection == 1){
                elfView.menu(controller);
            }
            else if(selection == 2){
                sataView.menu(controller);
            }
            else if (selection == 3) {
                break;
            }
        }
    }
            
    private int showMenu(){
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
