package io.egen.service;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.exception.BadRequestExp;
import io.egen.exception.ResNotFoundExp;
import io.egen.repository.ReadingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepo repo;

    @Transactional(readOnly = true)
    public List<Reading> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Reading findOne(String vin) {
        Reading existance = repo.findOne(vin);
        if (existance == null) {
            throw new ResNotFoundExp("Reading with " + vin + "doesn't exist!");
        }
        return repo.findOne(vin);
    }

    @Transactional
    public List<Reading> create(List<Reading> reads, Alert alert) {
        for (int i=0; i < reads.size(); i++) {
            Reading existance = repo.findOne(reads.get(i).getVin());
            if (existance != null) {
                update(reads.get(i).getVin(), reads.get(i));
            }
            else
            {
                repo.create(reads.get(i), alert);
            }
        }
        return reads;
    }

    @Transactional
    public Reading update(String vin, Reading reads) {
        Reading existance = repo.findOne(vin);
        if (existance == null) {
            throw new ResNotFoundExp("Reading with " + reads.getVin() + "already exists!");
        }
        return repo.update(reads);
    }

    @Transactional
    public void delete(String vin) {
        Reading existance = repo.findOne(vin);
        if (existance == null) {
            throw new ResNotFoundExp("Reading with " + vin + "doesn't exist!");
        }
        repo.delete(existance);
    }
}
