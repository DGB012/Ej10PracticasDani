package com.neoris.ej10PracticasDani.useCase;

import com.neoris.ej10PracticasDani.entities.Car;
import com.neoris.ej10PracticasDani.repository.CarsRepository;
import com.neoris.ej10PracticasDani.usecases.FindAllCarsUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllCarsUseCaseImpl implements FindAllCarsUseCase {
    //Aquí se encuentra la lógica de negocio y las operaciones necesarias para llevar a cabo los casos de uso

    private CarsRepository carsRepository;

    public FindAllCarsUseCaseImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public List<Car> findAll() {
        return carsRepository.findAll();
    }
}
