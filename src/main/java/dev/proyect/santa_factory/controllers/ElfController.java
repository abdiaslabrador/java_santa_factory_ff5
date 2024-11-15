package dev.proyect.santa_factory.controllers;
import dev.proyect.santa_factory.repositories.GoodToyRepository;
import dev.proyect.santa_factory.views.ElfView;
import dev.proyect.santa_factory.models.GoodChildToy;
import dev.proyect.santa_factory.dtos.GoodChildToyDto;



public class ElfController {

    private GoodToyRepository goodToyRepository;

    public ElfController(){
        goodToyRepository = new GoodToyRepository();
    }

    public  void elfMenu(){
        int selection;

        do{
            selection = ElfView.showElfMenu();
            if(selection == 1){
                addToyMenu();
            }
            if(selection == 4){
                ElfView.showCloseSession();
            }
        }while(selection != 4);
            
    }

    private void addToyMenu(){
        ElfView.showToyMenu();
        GoodChildToyDto gToyDto = ElfView.createGoodToyInputs();
        GoodChildToy goodChildToyDto = new GoodChildToy(gToyDto.title(), true, gToyDto.brand(), gToyDto.recommendedAge(), gToyDto.category());
        goodToyRepository.save(goodChildToyDto);
        ElfView.showToyAdded();
    }
    
}
