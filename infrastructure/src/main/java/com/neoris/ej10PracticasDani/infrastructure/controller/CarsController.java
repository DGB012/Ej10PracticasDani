package com.neoris.ej10PracticasDani.infrastructure.controller;

import com.neoris.ej10PracticasDani.entities.Car;
import com.neoris.ej10PracticasDani.usecases.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Utilizamos esta etiqueta para indicar que es un controlador del servicio Rest
public class CarsController {

    private FindAllCarsUseCase findAllCarsUseCase;  //Inyectamos las depencias de las interfaces
    // de los casos de uso que tenemos en elmódulo de application

    private FindByCarRegistrationCarUseCase findByCarRegistrationCarUseCase;

    private CreateCarUseCase createCarUseCase;

    private UpdateCarUseCase updateCarUseCase;

    private DeleteByCarRegistrationCarUseCase deleteByCarRegistrationCarUseCase;

    public CarsController(FindAllCarsUseCase findAllCarsUseCase, FindByCarRegistrationCarUseCase findByCarRegistrationCarUseCase, CreateCarUseCase createCarUseCase, UpdateCarUseCase updateCarUseCase, DeleteByCarRegistrationCarUseCase deleteByCarRegistrationCarUseCase) {
        this.findAllCarsUseCase = findAllCarsUseCase;
        this.findByCarRegistrationCarUseCase = findByCarRegistrationCarUseCase;
        this.createCarUseCase = createCarUseCase;
        this.updateCarUseCase = updateCarUseCase;
        this.deleteByCarRegistrationCarUseCase = deleteByCarRegistrationCarUseCase;
    }

    @GetMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(findAllCarsUseCase.findAll());
    }

    @GetMapping(value = "/car/{carRegistration}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getByCarRegistration(@PathVariable String carRegistration) {
        return ResponseEntity.ok(findByCarRegistrationCarUseCase.findByCarRegistrationCar(carRegistration));
    }

    @PostMapping("/car/new")
    public ResponseEntity<Car> createCar(@RequestBody Car newCar) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createCarUseCase.createCar(newCar));
    }

    @PutMapping("/car/update")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(updateCarUseCase.updateCar(car));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/car/delete/{carRegistration}")
    public ResponseEntity<Car> deleteCar(@PathVariable String carRegistration) {
        deleteByCarRegistrationCarUseCase.deleteByCarRegistration(carRegistration);
        return ResponseEntity.noContent().build();
    }
}
