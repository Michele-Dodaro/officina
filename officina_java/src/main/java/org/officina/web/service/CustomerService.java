package org.officina.web.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.officina.web.model.entity.Customer;
import org.officina.web.repository.CustomerRepository;

@ApplicationScoped
public class CustomerService {
    final CustomerRepository customerRepository;

    public CustomerService( CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Transactional
    public Customer createCustomer(Customer customer) {
        Customer customerSave = Customer.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
        customerRepository.persist(customerSave);
        return customerSave;
    }

    @Transactional
    public Customer ModifyCustomer(Customer customer) {
        Customer existingCustomer = (Customer) customerRepository.getByName(customer.getFirstName(), customer.getLastName());
        if (existingCustomer != null) {
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            return existingCustomer;
        }
        Customer customerSave = Customer.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
        customerRepository.persist(customerSave);
        return customerSave;
    }
}
