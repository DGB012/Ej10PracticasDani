package com.neoris.ej10PracticasDani.infrastructure.controller;

import com.neoris.ej10PracticasDani.entities.Car;
import com.neoris.ej10PracticasDani.usecases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CarsControllerTest {

    @Mock
    FindAllCarsUseCase findAllCarsUseCase;

    @Mock
    FindByCarRegistrationCarUseCase findByCarRegistrationCarUseCase;

    @Mock
    CreateCarUseCase createCarUseCase;

    @Mock
    UpdateCarUseCase updateCarUseCase;

    @Mock
    DeleteByCarRegistrationCarUseCase deleteByCarRegistrationCarUseCase;

    @InjectMocks
    CarsController carsController;

    Car car1;
    Car car2;

    List<Car> cars;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        car1 = new Car(1, "Toyota", "Corolla", "Azul", "ABC123");
        car2 = new Car(2, "Ford", "Mustang", "Rojo", "DEF456");
        cars = Arrays.asList(car1, car2);
    }

    @Test
    void findAll() {
        when(findAllCarsUseCase.findAll()).thenReturn(cars);
        ResponseEntity<List<Car>> result = carsController.getAllCars();
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(cars, result.getBody());
    }

    @Test
    void findByCarRegistration() {
        when(findByCarRegistrationCarUseCase.findByCarRegistrationCar("ABC123")).thenReturn(car1);
        ResponseEntity<Car> result = carsController.getByCarRegistration("ABC123");
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(car1, result.getBody());
    }

    @Test
    void createCar() {
        Car car3 = new Car(3, "Chevrolet", "Camaro", "Negro", "GHI789");
        when(createCarUseCase.createCar(new Car(3, "Chevrolet", "Camaro", "Negro", "GHI789"))).thenReturn(car3);
        ResponseEntity<Car> result = carsController.createCar(car3);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(car3, result.getBody());
    }

    @Test
    void updateCar() {
        car2.setColor("Negro");
        when(updateCarUseCase.updateCar(car2)).thenReturn(car2);
        ResponseEntity<Car> result = carsController.updateCar(car2);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(car2, result.getBody());
    }

    @Test
    void deleteCar() {
        ResponseEntity<Car> result = carsController.deleteCar("ABC123");
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }
}
