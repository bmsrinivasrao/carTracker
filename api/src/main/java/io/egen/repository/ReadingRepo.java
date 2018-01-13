package io.egen.repository;

import io.egen.entity.Alert;
import io.egen.entity.AlertsBulk;
import io.egen.entity.Reading;

import java.util.List;

public interface ReadingRepo {
    List<Reading> findAll();

    Reading findOne(String vin);

    List<AlertsBulk> findAllAlerts();

    Reading create(Reading reads, Alert alert, AlertsBulk alertBulk);

    Reading update(Reading reads, Alert alert , AlertsBulk alertsBulk);

    void delete(Reading reads);
}
