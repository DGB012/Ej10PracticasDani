package com.neoris.ej10PracticasDani.useCase;

import com.neoris.ej10PracticasDani.entities.Car;
import com.neoris.ej10PracticasDani.repository.CarsRepository;
import com.neoris.ej10PracticasDani.usecases.FindByCarRegistrationCarUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindByCarRegistrationCarUseCaseImpl implements FindByCarRegistrationCarUseCase {
    //Aquí se encuentra la lógica de negocio y las operaciones necesarias para llevar a cabo los casos de uso

    private CarsRepository carsRepository;

    public FindByCarRegistrationCarUseCaseImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public Car findByCarRegistrationCar(String carRegistration) {
        return carsRepository.findByCarRegistrationCar(carRegistration);
    }
}
