package io.egen.service;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import java.util.List;

public interface ReadingService {

    List<Reading> findAll();

    Reading findOne(String vin);

    Reading create(Reading reads, Alert alert);

    Reading update(String vin, Reading reads);

    void delete(String vin);
}
