package dev.proyect.santa_factory.views;

import java.util.List;

import dev.proyect.santa_factory.dtos.BadChildToyDto;
import dev.proyect.santa_factory.dtos.GoodChildToyDto;
import dev.proyect.santa_factory.models.BadChildToy;
import dev.proyect.santa_factory.models.GoodChildToy;

public class ElfView extends CloseSessionView {

    public static int showElfMenu(){
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

    public static int showToyMenu(){
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

    public static GoodChildToyDto createGoodToyInputs(){
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

    public static BadChildToyDto createBadToyInputs(){
        System.out.println("Ingrese el título:");
        String title = scanner.nextLine();
        System.out.println("Ingrese contenido:");
        String content = scanner.nextLine();
        BadChildToyDto badChildToy = new BadChildToyDto(title, content);
        return badChildToy;
    }

    public static void showToyAdded(){
        System.out.println("\nJuguete añadido con éxito");
    }    
    
    public static void showGoodAndBadToys(List<GoodChildToy> goodChildtoys, List<BadChildToy> badChildtoys){
        showGoodChidrenToys(goodChildtoys);
        showBadChidrenToys(badChildtoys);
    }

    public static void showGoodChidrenToys(List<GoodChildToy> toys){
        for (GoodChildToy goodChildToy : toys) {
            System.out.println(goodChildToy.toString());
        }
    }

    public static void showBadChidrenToys(List<BadChildToy> toys){
        for (BadChildToy badChildToy : toys) {
            System.out.println(badChildToy.toString());
        }
    }
}
