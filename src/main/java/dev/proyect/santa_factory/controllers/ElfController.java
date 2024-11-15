package dev.proyect.santa_factory.controllers;
import dev.proyect.santa_factory.repositories.GoodToyRepository;
import dev.proyect.santa_factory.repositories.BadToyRepository;
import dev.proyect.santa_factory.views.ElfView;
import dev.proyect.santa_factory.models.BadChildToy;
import dev.proyect.santa_factory.models.GoodChildToy;
import dev.proyect.santa_factory.dtos.GoodChildToyDto;

import java.util.List;

import dev.proyect.santa_factory.dtos.BadChildToyDto;



public class ElfController {

    private GoodToyRepository goodToyRepository;
    private BadToyRepository badToyRepository;

    public ElfController(){
        goodToyRepository = new GoodToyRepository();
        badToyRepository = new BadToyRepository();
    }

    public void postGoodChildToy(GoodChildToyDto gToyDto){
        goodToyRepository.save(new GoodChildToy(gToyDto.title(), gToyDto.brand(), gToyDto.recommendedAge(), gToyDto.category()));
        
    }

    public void postBadChildToy(BadChildToyDto bToyDto){
        badToyRepository.save(new BadChildToy(bToyDto.title(), bToyDto.content()));
       
    }

    public List<GoodChildToy> getGoodChildrenToys(){
        return goodToyRepository.getAll();
    }

    public List<BadChildToy> getBadChildrenToys(){
        return badToyRepository.getAll();
    }
    

}
