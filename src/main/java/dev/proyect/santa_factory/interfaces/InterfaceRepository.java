package dev.proyect.santa_factory.interfaces;

import java.util.List;

import dev.proyect.santa_factory.models.Toy;

public interface InterfaceRepository {
    public void save(Toy toy);
    public void delete(String id);
    public List<? extends Toy> getAll();
    // public Toy getOne();
    // public List<Toy> getAll();
}
