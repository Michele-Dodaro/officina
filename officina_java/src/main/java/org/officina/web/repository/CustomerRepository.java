package org.officina.web.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.officina.web.model.entity.Customer;

import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
    public List<Customer> getAll() {
        return listAll();
    }
    public List<Customer> getByName(String firstName, String lastName) {
        return find("firstName LastName", firstName, lastName).list();
    }
}
