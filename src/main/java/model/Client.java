
package model;

import java.io.Serializable;

public class Client implements Serializable{
    private int id;
    private String idCard;
    private String fullName;
    private String address;
    private String email;
    private String tel;
    private String note;

    public Client() {
    }
    public Client(int id, String idCard, String fullName, String address, String email, String tel) {
        this.id = id;
        this.idCard = idCard;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.tel = tel;
    }
    public Client(int id, String idCard, String fullName, String address, String email, String tel, String note) {
        this.id = id;
        this.idCard = idCard;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
}
