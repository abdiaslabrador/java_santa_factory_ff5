package dev.proyect.santa_factory.views;

import dev.proyect.santa_factory.models.Toy;

public abstract class CloseSessionView extends View{
    public static void showCloseSession() {
        System.out.println("Sesión cerrada correctamente.");
    }

    public static void showToy(Toy toy) {
        System.out.println(toy.toString());
    }

}
