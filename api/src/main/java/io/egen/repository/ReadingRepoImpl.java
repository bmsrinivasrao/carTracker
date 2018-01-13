package io.egen.repository;

import io.egen.entity.*;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReadingRepoImpl implements ReadingRepo {

    @Autowired
    VehicleService service;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Reading> findAll() {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findAll", Reading.class);
        return query.getResultList();
    }

    public List<AlertsBulk> findAllAlerts() {
        TypedQuery<AlertsBulk> query = entityManager.createNamedQuery("Alerts.findAll", AlertsBulk.class);
        return query.getResultList();
    }

    public Reading findOne(String vin) {
        return entityManager.find(Reading.class, vin);
    }

    public Reading create(Reading reads, Alert alert, AlertsBulk alertsBulk) {
        entityManager.persist(reads);
        reads.getTires().setVin(reads.getVin());
        entityManager.persist(reads.getTires());
        // Alert persistance
        entityManager.persist(alert);
        return reads;
    }

    public Reading update(Reading reads, Alert alert, AlertsBulk alertsBulk) {
        int high = 0, medium = 0, low = 0;
        Reading ExistReadings = findOne(reads.getVin());
        if(ExistReadings != null)
        {
            high = ExistReadings.getAlert().getHigh();
            medium = ExistReadings.getAlert().getMedium();
            low = ExistReadings.getAlert().getLow();
        }
        // RULES
        Vehicle existance = service.findOne(reads.getVin());
        if(reads.getTires().getFrontLeft() < 32 || reads.getTires().getFrontLeft() > 36 || reads.getTires().getFrontRight() < 32 || reads.getTires().getFrontRight() > 36
                || reads.getTires().getRearLeft() < 32 || reads.getTires().getRearLeft() > 36 || reads.getTires().getRearRight() < 32 || reads.getTires().getRearRight() > 36){
            System.out.println("LOW: createAlert TireAlert");
            low = low + 1;
            alertsBulk.setVin(reads.getVin());
            alertsBulk.setDescription("Tires Alert");
            alertsBulk.setAlertType("Low");
            alertsBulk.setTimeStamp(reads.getTimestamp());
            alertsBulk.setLatitude(reads.getLatitude());
            alertsBulk.setLongitude(reads.getLongitude());
            entityManager.persist(alertsBulk);
        }
        if(reads.isEngineCoolantLow() || reads.isCheckEngineLightOn()){
            System.out.println("LOW: createAlert EngineLow");
            low = low +1;
            alertsBulk.setVin(reads.getVin());
            alertsBulk.setDescription("Engin Coolant/CheckEnginLight Alert");
            alertsBulk.setAlertType("Low");
            alertsBulk.setTimeStamp(reads.getTimestamp());
            alertsBulk.setLatitude(reads.getLatitude());
            alertsBulk.setLongitude(reads.getLongitude());
            entityManager.persist(alertsBulk);
        }
        if(reads.getEngineRpm() > existance.getRedlineRpm()){
            System.out.println("HIGH: createAlert EngineLow");
            // EMAIL FUNCTION NEEDS TO CALL
            high = high + 1;
            alertsBulk.setVin(reads.getVin());
            alertsBulk.setDescription("Engin Low Alert");
            alertsBulk.setAlertType("High");
            alertsBulk.setTimeStamp(reads.getTimestamp());
            alertsBulk.setLatitude(reads.getLatitude());
            alertsBulk.setLongitude(reads.getLongitude());
            entityManager.persist(alertsBulk);
        }
        if((existance.getMaxFuelVolume()* 0.1) > reads.getFuelVolume()){
            System.out.println("MEDIUM: createAlert EngineLow");
            medium = medium + 1;
            alertsBulk.setVin(reads.getVin());
            alertsBulk.setDescription("Engin FuelLow Alert");
            alertsBulk.setAlertType("Medium");
            alertsBulk.setTimeStamp(reads.getTimestamp());
            alertsBulk.setLatitude(reads.getLatitude());
            alertsBulk.setLongitude(reads.getLongitude());
            entityManager.persist(alertsBulk);
        }

        entityManager.merge(reads);
        reads.getTires().setVin(reads.getVin());
        entityManager.merge(reads.getTires());
        // Setting Alert values
        alert.setVin(reads.getVin());
        alert.setHigh(high);
        alert.setMedium(medium);
        alert.setLow(low);
        // Alert persistance
        entityManager.merge(alert);
        return reads;
    }

    public void delete(Reading reads) {
        entityManager.remove(reads);
    }
}
