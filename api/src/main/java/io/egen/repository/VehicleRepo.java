package io.egen.repository;

import io.egen.entity.Vehicle;

import java.util.List;

public interface VehicleRepo {
    List<Vehicle> findAll();

    Vehicle findOne(String vin);

    Vehicle create(Vehicle veh);

    Vehicle update(Vehicle veh);

    void delete(Vehicle veh);
}
