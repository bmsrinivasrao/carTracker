package io.egen.repository;

import io.egen.entity.Reading;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReadingRepoImpl implements ReadingRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Reading> findAll() {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findAll", Reading.class);
        return query.getResultList();
    }

    public Reading findOne(String vin) {
        return entityManager.find(Reading.class, vin);
    }

    public Reading create(Reading reads) {
        entityManager.persist(reads);
        reads.getTires().setVin(reads.getVin());
        entityManager.persist(reads.getTires());
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
