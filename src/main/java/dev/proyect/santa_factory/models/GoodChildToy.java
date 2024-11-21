package dev.proyect.santa_factory.models;
import com.opencsv.bean.CsvBindByPosition;

public class GoodChildToy extends Toy{
    @CsvBindByPosition(position = 2)
    private String brand;
    @CsvBindByPosition(position = 3)
    private int recommendAge;
    @CsvBindByPosition(position = 4)
    private String category;
    private static int idGood=0;

    public GoodChildToy(String title, String brand, int recommendAge, String category){
        super(title, true);
        this.brand = brand;
        this.recommendAge = recommendAge;
        this.category = category;
        idGood +=1;
        setId(idGood);        
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
