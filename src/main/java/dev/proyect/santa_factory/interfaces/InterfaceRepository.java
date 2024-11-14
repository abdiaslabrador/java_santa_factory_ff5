package dev.proyect.santa_factory.interfaces;

import java.util.List;

import dev.proyect.santa_factory.models.Toy;

public interface InterfaceRepository {
    public void save();
    public List<Toy> delete();
    public Toy getOne();
    public List<Toy> getAll();
}
