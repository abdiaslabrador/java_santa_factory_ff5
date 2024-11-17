package dev.proyect.santa_factory.repositories;


import java.util.List;

import dev.proyect.santa_factory.database.Database;
import dev.proyect.santa_factory.interfaces.InterfaceRepository;
import dev.proyect.santa_factory.models.GoodChildToy;
import dev.proyect.santa_factory.models.Toy;

public class GoodToyRepository implements InterfaceRepository {

    @Override
    public void save(Toy toy) {
       if (toy.isGoodToy()) {
            toy.setId(Database.goodChildrenToys.size()+1);
            Database.goodChildrenToys.add((GoodChildToy) toy);
        }
    }

    @Override
    public void delete(String id) {
        Database.goodChildrenToys.removeIf(item -> item.getId() == id);
    }

    @Override
    public List<GoodChildToy> getAll() {
        return Database.goodChildrenToys;
    }

    // @Override
    // public Toy getOne() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    // }

    // @Override
    // public List<Toy> getAll() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    // }

    
}
