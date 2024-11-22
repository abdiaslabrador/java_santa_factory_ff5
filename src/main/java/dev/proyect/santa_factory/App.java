package dev.proyect.santa_factory;
import dev.proyect.santa_factory.controllers.ToyController;
import dev.proyect.santa_factory.views.MenuView;

public final class App {
    
    public static void main(String[] args) {
        
        ToyController controller = new ToyController(); 
        MenuView menu = new MenuView(controller);
        menu.start();
    }
}
