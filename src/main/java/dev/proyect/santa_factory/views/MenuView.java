package dev.proyect.santa_factory.views;

public class MenuView extends View{
    public static int showMainMenu(){
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
