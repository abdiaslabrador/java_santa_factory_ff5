package dev.proyect.santa_factory.models;

public class GoodChildToy extends Toy{

    private String brand;
    private String recommendAge;
    private String category;

    GoodChildToy(int id, String title){
        super(id, title);
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getRecommendAge() {
        return recommendAge;
    }


    public void setRecommendAge(String recommendAge) {
        this.recommendAge = recommendAge;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }

}
