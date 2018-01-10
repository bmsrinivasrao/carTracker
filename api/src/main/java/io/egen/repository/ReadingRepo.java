package io.egen.repository;

import io.egen.entity.Reading;

import java.util.List;

public interface ReadingRepo {
    List<Reading> findAll();

    Reading findOne(String vin);

    Reading create(Reading reads);

    Reading update(Reading reads);

    void delete(Reading reads);
}
