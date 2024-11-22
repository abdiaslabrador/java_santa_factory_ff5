package dev.proyect.santa_factory.models;
import com.opencsv.bean.CsvBindByPosition;

public abstract class Toy {
    @CsvBindByPosition(position = 0)
    private String id;
    @CsvBindByPosition(position = 1)
    private String title;

    private boolean isGoodToy;

    public Toy(int id, String title, boolean isGoodToy){
        this.title = title;
        this.isGoodToy = isGoodToy;
        setId(id);
    }

    public boolean isGoodToy() {
        return isGoodToy;
    }

    public void setGoodToy(boolean isGoodToy) {
        this.isGoodToy = isGoodToy;
    }
    
    public String getId() {
        return id;
    }

    public void setId(int id) {
        if (isGoodToy) {
            this.id = "B" + id;
        } else {
            this.id = "M" + id;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
