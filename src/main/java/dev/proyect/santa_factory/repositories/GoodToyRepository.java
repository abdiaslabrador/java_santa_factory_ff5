package dev.proyect.santa_factory.repositories;


import dev.proyect.santa_factory.database.Database;
import dev.proyect.santa_factory.interfaces.InterfaceRepository;
import dev.proyect.santa_factory.models.GoodChildToy;
import dev.proyect.santa_factory.models.Toy;

public class GoodToyRepository implements InterfaceRepository {

    public GoodToyRepository(){

    }

    @Override
    public void save(Toy toy) {
       if (toy.isGoodToy()) {
            Database.goodChildrenToys.add((GoodChildToy) toy);
        }
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
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
