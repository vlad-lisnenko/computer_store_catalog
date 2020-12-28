package sample.model;

import java.io.Serializable;

public class Device implements Serializable {
    private String name;
    private String countryOfManufacture;
    private String characteristic;
    private String price;
    private int count;

    public Device(String name, String countryOfManufacture, String characteristic, String price, int count){
        this.name = name;
        this.countryOfManufacture = countryOfManufacture;
        this.characteristic = characteristic;
        this.price = price;
        this.count = count;
    }

    @Override
    public String toString() {
        return getName() + " " + getCountryOfManufacture();
    }

    public String getPrice() { return price; }
    public String getCountryOfManufacture() { return countryOfManufacture; }
    public String getCharacteristic() { return characteristic; }
    public String getName() { return name; }
    public int getCount() { return count; }

    public void setName(String name) { this.name = name; }
    public void setCharacteristic(String characteristic) { this.characteristic = characteristic;}
    public void setCountryOfManufacture(String countryOfManufacture) { this.countryOfManufacture = countryOfManufacture; }
    public void setAvailability(int count) { this.count = count; }
    public void setPrice(String price) { this.price = price; }
}
