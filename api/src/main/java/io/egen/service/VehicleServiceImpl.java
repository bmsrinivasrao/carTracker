package io.egen.service;

import io.egen.entity.Vehicle;
import io.egen.exception.ResNotFoundExp;
import io.egen.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepo repo;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Vehicle findOne(String vin) {
        Vehicle existance = repo.findOne(vin);
        if (existance == null) {
            throw new ResNotFoundExp("Vehicle with " + vin + "doesn't exist!");
        }
        return repo.findOne(vin);
    }

    @Transactional
    public List<Vehicle> create(List<Vehicle> veh) {
        for (int i=0; i < veh.size(); i++)
        {
            Vehicle existance = repo.findOne(veh.get(i).getVin());
            if (existance != null) {
                update(veh.get(i).getVin(), veh.get(i));
                //throw new BadRequestExp("Vehicle with " + veh.getVin() + "doesn't exist!");
            }
            else
            {
                repo.create(veh.get(i));
            }
        }
        return veh;
    }

    @Transactional
    public Vehicle update(String vin, Vehicle veh) {
        Vehicle existance = repo.findOne(vin);
        if (existance == null) {
            throw new ResNotFoundExp("Vehicle with " + veh.getVin() + "already exists!");
        }
        return repo.update(veh);
    }

    @Transactional
    public void delete(String vin) {
        Vehicle existance = repo.findOne(vin);
        if (existance == null) {
            throw new ResNotFoundExp("Vehicle with " + vin + "doesn't exist!");
        }
        repo.delete(existance);
    }
}
