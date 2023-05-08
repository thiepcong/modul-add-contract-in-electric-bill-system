
package model;

import java.io.Serializable;

public class ElectricalMeter implements Serializable{
    private String meterCode;
    private int meterIndex;

    public ElectricalMeter() {
    }   

    public ElectricalMeter(String meterCode, int meterIndex) {
        this.meterCode = meterCode;
        this.meterIndex = meterIndex;
    }

    public String getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(String meterCode) {
        this.meterCode = meterCode;
    }

    public int getMeterIndex() {
        return meterIndex;
    }

    public void setMeterIndex(int meterIndex) {
        this.meterIndex = meterIndex;
    }

    
    
}
