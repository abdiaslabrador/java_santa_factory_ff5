package dev.proyect.santa_factory.interfaces;

import dev.proyect.santa_factory.models.Toy;

public interface InterfaceRepository {
    public void save(Toy toy);
    public void delete();
    // public Toy getOne();
    // public List<Toy> getAll();
}
