package io.egen.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({@NamedQuery(name = "Alerts.findAll", query = "SELECT alerts FROM AlertsBulk alerts ORDER BY alerts.vin DESC")})
public class AlertsBulk {

    @Id
    @Column(unique = true)
    private String id;
    private String vin;
    private String alertType;
    private String description;
    private String timeStamp;
    private double latitude;
    private double longitude;

    public AlertsBulk(){
        this.id = UUID.randomUUID().toString();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "AlertsBulk{" +
                "vin='" + vin + '\'' +
                "type='" + alertType + '\'' +
                "description='" + description + '\'' +
                "time='" + timeStamp + '\'' +
                "latitude='" + latitude + '\'' +
                "longitude='" + longitude + '\'' +
                '}';
    }
}
