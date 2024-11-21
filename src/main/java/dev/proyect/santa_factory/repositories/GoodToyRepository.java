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
            Database.goodChildrenToys.add((GoodChildToy) toy);
        }
    }

    @Override
    public boolean delete(String id) {
        return Database.goodChildrenToys.removeIf(item -> item.getId().toLowerCase().equals(id.toLowerCase()));
    }

    @Override
    public List<GoodChildToy> getAll() {
        return Database.goodChildrenToys;
    }
}
