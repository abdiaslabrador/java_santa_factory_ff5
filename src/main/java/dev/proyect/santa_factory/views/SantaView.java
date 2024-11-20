package dev.proyect.santa_factory.views;
import dev.proyect.santa_factory.controllers.ToyController;

public class SantaView extends SessionView {

    public void menu(ToyController controller){
        int selection;
        do{
            selection = showMenu();
            if(selection == 1){
                System.out.println("\nLista de juguetes para niños buenos:");
                showChidrenToys(controller.getGoodChildrenToys(), "No hay juguetes para niños buenos");
            }
            else if(selection == 2){
                System.out.println("\nLista de juguetes para niños malos:");
                showChidrenToys(controller.getBadChildrenToys(), "No hay juguetes para niños malos");
            }
            else if(selection == 3){
                controller.generateCsv();
            }
            else if(selection == 4){
                showCloseSession();
            }
        }while(selection != 4);
            
    }

    
    public int showMenu(){
        int selection = 0;
        while(selection < 1 || selection > 4) {
            System.out.println("\nGestor de juguetes (Tipo de sesión: Santa)");
            System.out.println("1. Ver lista de juguetes niños buenos");
            System.out.println("2. Ver lista de juguetes niños malos");
            System.out.println("3. Guargar lista de todos los juguetes (.csv)");
            System.out.println("4. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            selection = scanner.nextInt();
            scanner.nextLine();
        }
        return selection;
    }
    
    
}
