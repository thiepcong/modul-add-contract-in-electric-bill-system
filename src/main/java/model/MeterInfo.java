
package model;

import java.io.Serializable;
import java.util.Date;

public class MeterInfo implements Serializable{
    private int id;
    private Date installDate;
    private String status;
    private int startIndex;
    private int readingIndex;
    private Date readingDate;
    private ElectricHousehold h;
    private ElectricalMeter m;

    public MeterInfo() {
    }

    public MeterInfo(int id, Date installDate, String status, int startIndex, ElectricHousehold h, ElectricalMeter m) {
        this.id = id;
        this.installDate = installDate;
        this.status = status;
        this.startIndex = startIndex;
        this.h = h;
        this.m = m;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public ElectricHousehold getH() {
        return h;
    }

    public void setH(ElectricHousehold h) {
        this.h = h;
    }

    public ElectricalMeter getM() {
        return m;
    }

    public void setM(ElectricalMeter m) {
        this.m = m;
    }

    public int getReadingIndex() {
        return readingIndex;
    }

    public void setReadingIndex(int readingIndex) {
        this.readingIndex = readingIndex;
    }

    public Date getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(Date readingDate) {
        this.readingDate = readingDate;
    }
    
}
