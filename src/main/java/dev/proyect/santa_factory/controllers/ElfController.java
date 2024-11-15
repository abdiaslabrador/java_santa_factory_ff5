package dev.proyect.santa_factory.controllers;
import dev.proyect.santa_factory.repositories.GoodToyRepository;
import dev.proyect.santa_factory.repositories.BadToyRepository;
import dev.proyect.santa_factory.views.ElfView;
import dev.proyect.santa_factory.models.BadChildToy;
import dev.proyect.santa_factory.models.GoodChildToy;
import dev.proyect.santa_factory.dtos.GoodChildToyDto;
import dev.proyect.santa_factory.dtos.BadChildToyDto;



public class ElfController {

    private GoodToyRepository goodToyRepository;
    private BadToyRepository badToyRepository;

    public ElfController(){
        goodToyRepository = new GoodToyRepository();
        badToyRepository = new BadToyRepository();
    }

    public  void elfMenu(){
        int selection;
        int goodOrbadSelection;
        do{
            selection = ElfView.showElfMenu();
            if(selection == 1){
                goodOrbadSelection = ElfView.showToyMenu();
                if(goodOrbadSelection == 1){
                    addGoodChildToy();
                }
                if(goodOrbadSelection == 2){
                    addBadChildToy();
                }
            }
            if(selection == 4){
                ElfView.showCloseSession();
            }
        }while(selection != 4);
            
    }

    private void addGoodChildToy(){
        GoodChildToyDto gToyDto = ElfView.createGoodToyInputs();
        goodToyRepository.save(new GoodChildToy(gToyDto.title(), gToyDto.brand(), gToyDto.recommendedAge(), gToyDto.category()));
        ElfView.showToyAdded();
    }

    private void addBadChildToy(){
        BadChildToyDto bToyDto = ElfView.createBadToyInputs();
        badToyRepository.save(new BadChildToy(bToyDto.title(), bToyDto.content()));
        ElfView.showToyAdded();
    }
}
