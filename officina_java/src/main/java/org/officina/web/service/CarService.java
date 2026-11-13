package org.officina.web.service;

import jakarta.transaction.Transactional;
import org.officina.web.model.entity.Car;
import org.officina.web.repository.CarRepository;
import org.officina.web.repository.CustomerRepository;

public class CarService {
    final CarRepository carRepository;
    final CustomerRepository customerRepository;

    public CarService(CarRepository carRepository, CustomerRepository customerRepository) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }
    @Transactional
    public Car createCar(Car car) {
        if (car.getPlate() != null) {
            Car existingCar = carRepository.getByPlate(car.getPlate());
            if (existingCar != null) {
                existingCar.setPlate(car.getPlate());
                existingCar.setCustomer(car.getCustomer());
                existingCar.setState(car.getState());
                return existingCar;
            }
        }

        Car carSave = Car.builder()
                .plate(car.getPlate())
                .customer(car.getCustomer())
                .state(car.getState())
                .build();

        carRepository.persist(carSave);
        return carSave;
    }
}
