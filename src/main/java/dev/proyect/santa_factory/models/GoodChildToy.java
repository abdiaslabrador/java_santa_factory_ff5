package dev.proyect.santa_factory.models;

public class GoodChildToy extends Toy{

    private String brand;
    private int recommendAge;
    private String category;

    public GoodChildToy(String title, String brand, int recommendAge, String category){
        super(title, true);
        this.brand = brand;
        this.recommendAge = recommendAge;
        this.category = category;        
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public int getRecommendAge() {
        return recommendAge;
    }


    public void setRecommendAge(int recommendAge) {
        this.recommendAge = recommendAge;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public String toString() {
        return  this.getId()+". " + 
                "Titulo: " + this.getTitle() + 
                ", Marca: " + this.brand +
                ", Edad: " + this.recommendAge + 
                ", Categoria: " + this.category;
    }
}
