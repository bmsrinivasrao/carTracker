package io.egen.entity;

import javax.persistence.*;

@Entity
public class Alert {

    @Id
    private String vin;
    private int high;
    private int medium;
    private int low;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getMedium() {
        return medium;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "high='" + high + '\'' +
                "medium='" + medium + '\'' +
                "low='" + low + '\'' +
                '}';
    }
}
