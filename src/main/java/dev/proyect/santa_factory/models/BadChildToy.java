package dev.proyect.santa_factory.models;

public class BadChildToy extends Toy{
    String content;

    public BadChildToy(String title, String content){
        super(title, false);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    @Override
    public String toString() {
        return  "\nID: " + this.getId() +
                "\nTitulo: " + this.getTitle() +
                "\nContenido: " + this.content;
    }
}
