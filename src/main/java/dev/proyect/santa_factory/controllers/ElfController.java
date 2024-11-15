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
        int goodOrbadSelection;
        do{
            selection = ElfView.showElfMenu();
            if(selection == 1){
                goodOrbadSelection = ElfView.showToyMenu();
                if(goodOrbadSelection == 1){
                    addGoodToy();
                }
                if(goodOrbadSelection == 2){
                    
                }
            }
            if(selection == 4){
                ElfView.showCloseSession();
            }
        }while(selection != 4);
            
    }

    private void addGoodToy(){
        GoodChildToyDto gToyDto = ElfView.createGoodToyInputs();
        goodToyRepository.save(new GoodChildToy(gToyDto.title(), true, gToyDto.brand(), gToyDto.recommendedAge(), gToyDto.category()));
        ElfView.showToyAdded();
    }
}
