package io.egen.repository;

import io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepoImpl implements VehicleRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();
    }

    public Vehicle findOne(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }

    public Vehicle create(Vehicle veh) {
        entityManager.persist(veh);
        return veh;
    }

    public Vehicle update(Vehicle veh) {
        entityManager.merge(veh);
        return veh;
    }

    public void delete(Vehicle veh) {
        entityManager.remove(veh);
    }
}
