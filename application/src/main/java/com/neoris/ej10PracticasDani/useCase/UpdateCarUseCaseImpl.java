package com.neoris.ej10PracticasDani.useCase;

import com.neoris.ej10PracticasDani.entities.Car;
import com.neoris.ej10PracticasDani.repository.CarsRepository;
import com.neoris.ej10PracticasDani.usecases.UpdateCarUseCase;
import org.springframework.stereotype.Component;

@Component
public class UpdateCarUseCaseImpl implements UpdateCarUseCase {
    //Aquí se encuentra la lógica de negocio y las operaciones necesarias para llevar a cabo los casos de uso

    private CarsRepository carsRepository;

    public UpdateCarUseCaseImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public Car updateCar(Car car) {
        return carsRepository.updateCar(car);
    }
}
