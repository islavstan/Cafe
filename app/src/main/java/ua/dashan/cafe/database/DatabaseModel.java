package ua.dashan.cafe.database;


public class DatabaseModel {
    private int id;
    private String name;
    private String consist;
    private int photo;
    private int price;
    private int weight;
    private String category;

    public DatabaseModel(String name,String consist,int price,int photo,String category,int weight){
       this.weight=weight;
        this.name=name;
        this.price=price;
        this.photo=photo;
        this.category=category;
        this.consist=consist;

    }
    public DatabaseModel(){};
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getConsist() {
        return consist;
    }

    public void setConsist(String consist) {
        this.consist = consist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
