
package model;

import java.io.Serializable;
public class ElectricHousehold implements Serializable{
    private String houseId;
    private String address;

    public ElectricHousehold() {
    }

    public ElectricHousehold(String houseId, String address) {
        this.houseId = houseId;
        this.address = address;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
