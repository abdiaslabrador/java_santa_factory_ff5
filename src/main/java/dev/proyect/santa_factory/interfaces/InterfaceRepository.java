package dev.proyect.santa_factory.interfaces;

import java.util.List;

import dev.proyect.santa_factory.models.Toy;

public interface InterfaceRepository {
    public void save(Toy toy);
    public boolean delete(String id);
    public List<? extends Toy> getAll();
}
