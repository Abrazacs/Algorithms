package HomeWork5;

public class Item {
    String name;
    private double price;
    private double weight;


    public Item (double price, double weight, String name){
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public double getPrice(){
        return price;
    }

    public  double getWeight(){
        return weight;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return this.name;
    }

}
