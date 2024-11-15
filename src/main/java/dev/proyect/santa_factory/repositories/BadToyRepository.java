package dev.proyect.santa_factory.repositories;

import dev.proyect.santa_factory.database.Database;
import dev.proyect.santa_factory.interfaces.InterfaceRepository;
import dev.proyect.santa_factory.models.BadChildToy;
import dev.proyect.santa_factory.models.Toy;

public class BadToyRepository implements InterfaceRepository{

    @Override
    public void save(Toy toy) {
        if (!toy.isGoodToy()) {
            Database.badChildrenToys.add((BadChildToy) toy);
        }
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
