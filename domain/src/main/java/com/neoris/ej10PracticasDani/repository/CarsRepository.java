package com.neoris.ej10PracticasDani.repository;

import com.neoris.ej10PracticasDani.entities.Car;

import java.util.List;

public interface CarsRepository {
    //Interfaz en la que indicamos que metodos vamos a utilizar en el repository de infrastructure

    List<Car> findAll();

    Car findByCarRegistrationCar(String carRegistration);

    Car createCar(Car newCar);

    Car updateCar(Car car);

    void deleteByCarRegistration(String carRegistration);
}
