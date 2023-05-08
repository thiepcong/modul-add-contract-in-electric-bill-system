
package model;

import java.io.Serializable;
import java.util.Date;

public class Contract implements Serializable{
    private String contractID;
    private Date signTime;
    private Date duration;
    private User user;
    private Client client;

    public Contract() {
    }

    public Contract(String contractID, Date signTime, Date duration) {
        this.contractID = contractID;
        this.signTime = signTime;
        this.duration = duration;
    }

    public Contract(String contractID, Date signTime, Date duration, User user, Client client) {
        this.contractID = contractID;
        this.signTime = signTime;
        this.duration = duration;
        this.user = user;
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    
}
