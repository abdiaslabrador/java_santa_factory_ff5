package dev.proyect.santa_factory.views;

import java.util.Scanner;

import dev.proyect.santa_factory.controllers.ToyController;
import dev.proyect.santa_factory.dtos.BadChildToyDto;
import dev.proyect.santa_factory.dtos.GoodChildToyDto;
import dev.proyect.santa_factory.models.BadChildToy;
import dev.proyect.santa_factory.models.GoodChildToy;

public class ElfView extends SessionView{
    
    public static void menu(ToyController controller){
        int selection;
        int goodOrbadSelection;
        do{
            selection = showMenu(scanner);
            if(selection == 1){
                goodOrbadSelection = showToyMenu(scanner);
                if(goodOrbadSelection == 1){
                    GoodChildToyDto gToy = createGoodToyInputs(scanner);
                    controller.postGoodChildToy(new GoodChildToy(gToy.title(), gToy.brand(), gToy.recommendedAge(), gToy.category()));
                    showToyAdded();
                }
                if(goodOrbadSelection == 2){
                    BadChildToyDto bToyDto = createBadToyInputs(scanner);
                    controller.postBadChildToy(new BadChildToy(bToyDto.title(), bToyDto.content()));
                    showToyAdded();
                }
            }
            else if(selection == 2){
                showGoodAndBadToys(controller);
            }
            else if(selection == 3){
                showToysToDelete(controller, scanner);
            }else if(selection == 4){
                showCloseSession();
            }
        }while(selection != 4);
            
    }

    public static int showMenu(Scanner scanner){
        int selection = 0;
        while(selection < 1 || selection > 4) {
            System.out.println("\nGestor de juguetes (Tipo de sesión: Elfo)");
            System.out.println("1. Añadir juguete");
            System.out.println("2. Ver todos los juguetes");
            System.out.println("3. Eliminar juguete");
            System.out.println("4. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            selection = scanner.nextInt();
            scanner.nextLine();
        }
        return selection;
    }

    public static int showToyMenu(Scanner scanner){
        int selection = 0;
        while(selection < 1 || selection > 2) {
            System.out.println("\nPara niño ...:");
            System.out.println("1. Bueno");
            System.out.println("2. Malo");
            System.out.println("Seleccione una opción: ");
            selection = scanner.nextInt();
            scanner.nextLine();
        }
        return selection;
    }

    public static GoodChildToyDto createGoodToyInputs(Scanner scanner){
        System.out.println("Ingrese el título:");
        String title = scanner.nextLine();
        System.out.println("Ingrese la marca:");
        String brand = scanner.nextLine();
        System.out.println("Ingrese la edad recomendada:");
        int recommendedAge = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la categoria:");
        String category = scanner.nextLine();
        GoodChildToyDto goodChildToy = new GoodChildToyDto(title, brand, recommendedAge, category);
        return goodChildToy;
    }

    public static  BadChildToyDto createBadToyInputs(Scanner scanner){
        System.out.println("Ingrese el título:");
        String title = scanner.nextLine();
        System.out.println("Ingrese contenido:");
        String content = scanner.nextLine();
        BadChildToyDto badChildToy = new BadChildToyDto(title, content);
        return badChildToy;
    }

    public static  void showToyAdded(){
        System.out.println("\nJuguete añadido con éxito");
    }    
    
    public static  void showGoodAndBadToys(ToyController controller){
        System.out.println("\nLista de juguetes:");
        showChildrenToys(controller.getGoodChildrenToys(), "No hay juguetes para niños buenos");
        showChildrenToys(controller.getBadChildrenToys(), "No hay juguetes para niños malos");
    }

    public static void showToysToDelete(ToyController controller, Scanner scanner){
        if(controller.getGoodChildrenToys().size() > 0 || controller.getBadChildrenToys().size() > 0){
            System.out.println("\nLista de juguetes:");
            for (GoodChildToy goodChildToy : controller.getGoodChildrenToys()) {
                System.out.println(goodChildToy.getId() + ". Titulo: " + goodChildToy.getTitle());
            }   
            for (BadChildToy badChildToy : controller.getBadChildrenToys()) {
                System.out.println(badChildToy.getId() + ". Titulo: " + badChildToy.getTitle());
            }
            idToDeleteInput(controller, scanner);
        }else{
            System.out.println("\nNo hay juguetes para eliminar");
        }
    }

    public static void idToDeleteInput(ToyController controller, Scanner scanner){
        System.out.print("Ingrese el identificador del juguete a eliminar: ");
        String id = scanner.nextLine();
        if(controller.deleteChildrenToy(id)){
            System.out.println("Juguete eliminado con éxito");
        }else{
            System.out.println("Juguete no encontrado");
        }
    }
}
