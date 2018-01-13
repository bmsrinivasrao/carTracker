package io.egen.entity;
import javax.persistence.*;

@Entity
public class Tire {

    @Id
    private String vin;
    private int frontLeft;
    private int frontRight;
    private int rearLeft;
    private int rearRight;

    public Tire(){
        this.vin = "";
    }

    public String getVin(String u) {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }

    @Override
    public String toString() {
        return "Tire{" +
                "frontLeft='" + frontLeft + '\'' +
                "frontRight='" + frontRight + '\'' +
                "rearLeft='" + rearLeft + '\'' +
                "rearRight='" + rearRight + '\'' +
                '}';
    }
}
