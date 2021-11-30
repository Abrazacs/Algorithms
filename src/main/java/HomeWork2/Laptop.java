package HomeWork2;

public class Laptop {
    private int price;
    private int ram;
    private Manufacturer manufacturer;

    public Laptop(){
        this.price = 500+(int)(Math.random()*50)*50;
        this.ram = 4+(int)(Math.random()*5)*4;
        this.manufacturer = Manufacturer.values()[1+(int)(Math.random()*4)];
    }

    public int getPrice(){
        return price;
    }

    public int getRam(){
        return ram;
    }

    public Manufacturer getManufacturer(){
        return manufacturer;
    }

    @Override
    public String toString(){
      return "Laptop{"
              + "Manufcaturer: " + this.manufacturer
              + " ram: " + this.ram
              + " price: " + this.price
              +"}";
    }
}
