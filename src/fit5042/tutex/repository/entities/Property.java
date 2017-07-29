/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository.entities;

import java.text.NumberFormat;

/**
 *
 * @author Jian
 * 
 */
public class Property {

    private int id;
    private String address;
    private double size;
    private int bedroomCount;
    private double price;
    
    public Property(int id, String address,  int bedroomCount, double size, double price) {
        this.id = id;
        this.address = address;
        this.size = size;
        this.bedroomCount = bedroomCount;
        this.price = price;
    }

    public int getBedroomCount() {
        return bedroomCount;
    }

    public void setBedroomCount(int bedroomCount) {
        this.bedroomCount = bedroomCount;
    }
   

    @Override
    public String toString() {
        return  id + ". " + address + ", " +bedroomCount+"BR(s), " + size + " sqm, " +  NumberFormat.getCurrencyInstance().format(price);
    }      

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   
   //TODO Exercise 1A Step 1 Please refer tutorial exercise. 
    
    
}
