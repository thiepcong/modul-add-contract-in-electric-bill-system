package model;

import java.io.Serializable;


public class User implements Serializable{
    private int id;
    private String username;
    private String password;
    private String fullName;
    private String position;
    private String note;
    public User() {
    }

    public User(int id, String username, String password, String fullName, String position) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.position = position;
    }

    public User(int id, String username, String password, String fullName, String position, String note) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.position = position;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
}
