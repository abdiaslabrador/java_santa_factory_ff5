package dev.proyect.santa_factory;
import dev.proyect.santa_factory.controllers.ToyController;
import dev.proyect.santa_factory.models.BadChildToy;
import dev.proyect.santa_factory.models.GoodChildToy;
import dev.proyect.santa_factory.views.ElfView;
import dev.proyect.santa_factory.views.MenuView;
import dev.proyect.santa_factory.views.SantaView;

public final class App {
    
    public static void main(String[] args) {
        
        ToyController controller = new ToyController(); 
        ElfView elfView = new ElfView();
        SantaView santaView = new SantaView();
        MenuView menu = new MenuView(controller, elfView, santaView);
        menu.start();
    }
}
