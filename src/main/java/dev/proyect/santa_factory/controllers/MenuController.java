package dev.proyect.santa_factory.controllers;
import dev.proyect.santa_factory.views.MenuView;

public class MenuController {
    ElfController elfController;

    public MenuController(){
        elfController = new ElfController();
    }

    public void start(){
        while (true) {
            
            int selection = MenuView.showMainMenu();
            
            if(selection == 1){
                elfController.elfMenu();
            }
            if (selection == 3) {
                break;
            }
        }
        
    }
}