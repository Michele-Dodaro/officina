package org.officina.web.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.officina.web.model.entity.Car;
import org.officina.web.repository.CarRepository;
import org.officina.web.repository.CustomerRepository;

import java.util.List;

@ApplicationScoped
public class CarService {
    final CarRepository carRepository;
    final CustomerRepository customerRepository;

    public CarService(CarRepository carRepository, CustomerRepository customerRepository) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }
    @Transactional
    public Car createCar(Car car) {
        Car carSave = null;
        if (car.getPlate() != null) {
            carSave = Car.builder()
                    .plate(car.getPlate())
                    .customer(car.getCustomer())
                    .state(car.getState())
                    .build();


        }
        carRepository.persist(carSave);
        return carSave;
    }
    @Transactional
    public Car updateCar(Car car) {
        Car existingCar = carRepository.getByPlate(car.getPlate());
        if (existingCar != null) {
            existingCar.setState(car.getState());
            existingCar.setStartCheck(car.getStartCheck());
            existingCar.setEndCheck(car.getEndCheck());
            existingCar.setWithdraw(car.getWithdraw());
            return existingCar;
        }
        Car carSave = Car.builder()
                .plate(car.getPlate())
                .customer(car.getCustomer())
                .state(car.getState())
                .startCheck(car.getStartCheck())
                .endCheck(car.getEndCheck())
                .withdraw(car.getWithdraw())
                .build();

        carRepository.persist(carSave);
        return carSave;
    }
    @Transactional
    public Car modifyCar(Car car) {
        Car existingCar = carRepository.getByPlate(car.getPlate());
        if (existingCar != null) {
            existingCar.setPlate(car.getPlate());
            existingCar.setCustomer(car.getCustomer());
            existingCar.setArrive(car.getArrive());
            existingCar.setState(car.getState());
            existingCar.setStartCheck(car.getStartCheck());
            existingCar.setEndCheck(car.getEndCheck());
            existingCar.setWithdraw(car.getWithdraw());

        }
        Car carSave = Car.builder()
                .plate(car.getPlate())
                .customer(car.getCustomer())
                .arrive(car.getArrive())
                .state(car.getState())
                .startCheck(car.getStartCheck())
                .endCheck(car.getEndCheck())
                .withdraw(car.getWithdraw())
                .build();

        carRepository.persist(carSave);
        return carSave;
    }

}
