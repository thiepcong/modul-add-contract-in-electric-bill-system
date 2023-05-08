
package model;

import java.io.Serializable;

public class ContractType implements Serializable{
    private int id;
    private String type;
    private float price;
    private int priceLadder;

    public ContractType() {
    }

    public ContractType(int id, String type, float price, int priceLadder) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.priceLadder = priceLadder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPriceLadder() {
        return priceLadder;
    }

    public void setPriceLadder(int priceLadder) {
        this.priceLadder = priceLadder;
    }
    
    
}
