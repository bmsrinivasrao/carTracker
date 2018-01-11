package io.egen.repository;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Tire;
import io.egen.entity.Vehicle;
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
    Alert alert;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Reading> findAll() {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findAll", Reading.class);
        return query.getResultList();
    }

    public Reading findOne(String vin) {
        return entityManager.find(Reading.class, vin);
    }

    public Reading create(Reading reads, Alert alert) {
        int high = 0, medium = 0, low = 0;
        // RULES
        Vehicle existance = service.findOne(reads.getVin());
        if(reads.getEngineRpm() > existance.getRedlineRpm()){
            System.out.println("HIGH: createAlert EngineLow");
            high = 1;
        }
        if((existance.getMaxFuelVolume()* 0.1) > reads.getFuelVolume()){
            System.out.println("MEDIUM: createAlert EngineLow");
            medium = 1;
        }
        if(reads.getTires().getFrontLeft() < 32 || reads.getTires().getFrontLeft() > 36 || reads.getTires().getFrontRight() < 32 || reads.getTires().getFrontRight() > 36
                || reads.getTires().getRearLeft() < 32 || reads.getTires().getRearLeft() > 36 || reads.getTires().getRearRight() < 32 || reads.getTires().getRearRight() > 36){
            System.out.println("LOW: createAlert TireAlert");
            low = 1;
        }
        if(reads.isEngineCoolantLow() || reads.isCheckEngineLightOn()){
            System.out.println("LOW: createAlert EngineLow");
            low = low +1;
        }
        // Readings with Tire persistance
        entityManager.persist(reads);
        reads.getTires().setVin(reads.getVin());
        entityManager.persist(reads.getTires());
        // Setting Alert values
        alert.setVin(reads.getVin());
        alert.setHigh(high);
        alert.setMedium(medium);
        alert.setLow(low);
        // Alert persistance
        entityManager.persist(alert);
        return reads;
    }

    public Reading update(Reading reads) {
        entityManager.merge(reads);
        reads.getTires().setVin(reads.getVin());
        entityManager.merge(reads.getTires());
        return reads;
    }

    public void delete(Reading reads) {
        entityManager.remove(reads);
    }
}
