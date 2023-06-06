package com.neoris.ej10PracticasDani.useCase;

import com.neoris.ej10PracticasDani.repository.CarsRepository;
import com.neoris.ej10PracticasDani.usecases.DeleteByCarRegistrationCarUseCase;
import org.springframework.stereotype.Component;

@Component
public class DeleteByCarRegistrationCarUseCaseImpl implements DeleteByCarRegistrationCarUseCase {
    //Aquí se encuentra la lógica de negocio y las operaciones necesarias para llevar a cabo los casos de uso

    private CarsRepository carsRepository;

    public DeleteByCarRegistrationCarUseCaseImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public void deleteByCarRegistration(String carRegistration) {
        carsRepository.deleteByCarRegistration(carRegistration);
    }
}
