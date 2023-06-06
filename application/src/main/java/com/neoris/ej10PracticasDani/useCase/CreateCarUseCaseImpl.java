package com.neoris.ej10PracticasDani.useCase;

import com.neoris.ej10PracticasDani.entities.Car;
import com.neoris.ej10PracticasDani.repository.CarsRepository;
import com.neoris.ej10PracticasDani.usecases.CreateCarUseCase;
import org.springframework.stereotype.Component;

@Component
public class CreateCarUseCaseImpl implements CreateCarUseCase {
    //Aquí se encuentra la lógica de negocio y las operaciones necesarias para llevar a cabo los casos de uso
    private CarsRepository carsRepository;

    public CreateCarUseCaseImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public Car createCar(Car newCar) {
        return carsRepository.createCar(newCar);
    }
}
