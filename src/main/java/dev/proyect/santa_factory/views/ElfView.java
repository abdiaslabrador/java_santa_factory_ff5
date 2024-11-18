package dev.proyect.santa_factory.views;

import dev.proyect.santa_factory.controllers.ToyController;
import dev.proyect.santa_factory.dtos.BadChildToyDto;
import dev.proyect.santa_factory.dtos.GoodChildToyDto;
import dev.proyect.santa_factory.models.BadChildToy;
import dev.proyect.santa_factory.models.GoodChildToy;

public class ElfView extends SessionView{
    
    public void menu(ToyController controller){
        int selection;
        int goodOrbadSelection;
        do{
            selection = showMenu();
            if(selection == 1){
                goodOrbadSelection = showToyMenu();
                if(goodOrbadSelection == 1){
                    controller.postGoodChildToy(createGoodToyInputs());
                    showToyAdded();
                }
                if(goodOrbadSelection == 2){
                    controller.postBadChildToy(createBadToyInputs());
                    showToyAdded();
                }
            }
            else if(selection == 2){
                showGoodAndBadToys(controller);
            }
            else if(selection == 3){
                showToysToDelete(controller);
            }else if(selection == 4){
                showCloseSession();
            }
        }while(selection != 4);
            
    }

    private int showMenu(){
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

    private int showToyMenu(){
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

    private GoodChildToyDto createGoodToyInputs(){
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

    private BadChildToyDto createBadToyInputs(){
        System.out.println("Ingrese el título:");
        String title = scanner.nextLine();
        System.out.println("Ingrese contenido:");
        String content = scanner.nextLine();
        BadChildToyDto badChildToy = new BadChildToyDto(title, content);
        return badChildToy;
    }

    private void showToyAdded(){
        System.out.println("\nJuguete añadido con éxito");
    }    
    
    private void showGoodAndBadToys(ToyController controller){
        System.out.println("\nLista de juguetes:");
        showChidrenToys(controller.getGoodChildrenToys(), "No hay juguetes para niños buenos");
        showChidrenToys(controller.getBadChildrenToys(), "No hay juguetes para niños malos");
    }

    private void showToysToDelete(ToyController controller){
        if(controller.getGoodChildrenToys().size() > 0 || controller.getBadChildrenToys().size() > 0){
            System.out.println("\nLista de juguetes:");
            for (GoodChildToy goodChildToy : controller.getGoodChildrenToys()) {
                System.out.println(goodChildToy.getId() + ". Título: " + goodChildToy.getTitle());
            }   
            for (BadChildToy badChildToy : controller.getBadChildrenToys()) {
                System.out.println(badChildToy.getId() + ". Título: " + badChildToy.getTitle());
            }
            idToDeleteInput(controller);
        }else{
            System.out.println("\nNo hay juguetes para eliminar");
        }
    }

    private void idToDeleteInput(ToyController controller){
        System.out.print("Ingrese el identificador del juguete a eliminar: ");
        String id = scanner.nextLine();
        if(controller.deleteChildrenToy(id)){
            System.out.println("Juguete eliminado con éxito");
        }else{
            System.out.println("Juguete no encontrado");
        }
    }
}
