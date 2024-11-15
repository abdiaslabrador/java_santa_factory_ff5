package dev.proyect.santa_factory.models;

public abstract class Toy {
    private String id;
    private String title;
    private boolean isGoodToy;
    private static int maxId = 1;

    public Toy(String title, boolean isGoodToy){
        this.title = title;
        this.isGoodToy = isGoodToy;
        setId(maxId++);
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
