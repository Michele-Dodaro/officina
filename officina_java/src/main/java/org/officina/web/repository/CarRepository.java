package org.officina.web.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.officina.web.model.entity.Car;
import org.officina.web.model.entity.Customer;

import java.security.Timestamp;
import java.util.List;

@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {
    List<Car> getAll() {
        return listAll();
    }
    public Car getByPlate(String plate) {
        return find("plate", plate).firstResult();
    }
    public List<Car> getByDate(Timestamp arrive, Timestamp withdraw) {
        return find("arrive withdraw", arrive, withdraw).list();
    }
    public List<Car> getByState(String state) {
        return find("state", state).list();
    }
    public boolean existsByPlate(String plate) {;
        return find("plate", plate).firstResult() != null;

    }
}
