package dev.proyect.santa_factory.repositories;

import java.util.List;

import dev.proyect.santa_factory.database.Database;
import dev.proyect.santa_factory.interfaces.InterfaceRepository;
import dev.proyect.santa_factory.models.BadChildToy;
import dev.proyect.santa_factory.models.Toy;

public class BadToyRepository implements InterfaceRepository{

    @Override
    public List<BadChildToy> getAll() {
        return Database.badChildrenToys;
    }

    @Override
    public void save(Toy toy) {
        if (!toy.isGoodToy()) {
            Database.badChildrenToys.add((BadChildToy) toy);
        }
    }

    @Override
    public boolean delete(String id) {
        return Database.badChildrenToys.removeIf(item -> item.getId().toLowerCase().equals(id.toLowerCase()));
    }
    
}
