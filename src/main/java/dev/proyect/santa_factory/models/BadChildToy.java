package dev.proyect.santa_factory.models;
import com.opencsv.bean.CsvBindByPosition;

public class BadChildToy extends Toy{
    @CsvBindByPosition(position = 2)
    String content;
    private static int idBad=0;

    public BadChildToy(String title, String content){ 
        super(idBad+=1, title, false);
        this.content = content;
    }

    public BadChildToy(int id, String title, String content){
        super(id, title, false);
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
        return  this.getId() + 
                ". Titulo: " + this.getTitle() + 
                ", Contenido: " + this.content;
    }
}
