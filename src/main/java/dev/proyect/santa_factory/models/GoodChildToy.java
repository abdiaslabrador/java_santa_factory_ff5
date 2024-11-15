package dev.proyect.santa_factory.models;

public class GoodChildToy extends Toy{

    private String brand;
    private int recommendAge;
    private String category;

    public GoodChildToy(String title, boolean isGoodToy, String brand, int recommendAge, String category){
        super(title, isGoodToy);
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
        return  "\nID: " + this.getId() +
                "\nTitulo: " + this.getTitle() +
                "\nMarca: " + this.brand +
                "\nEdad: " + this.recommendAge +
                "\nCategoria: " + this.category;
    }
}
