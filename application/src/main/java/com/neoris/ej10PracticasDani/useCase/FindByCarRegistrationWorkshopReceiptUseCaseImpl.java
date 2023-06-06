package com.neoris.ej10PracticasDani.useCase;

import com.neoris.ej10PracticasDani.entities.WorkshopReceipt;
import com.neoris.ej10PracticasDani.repository.WorkshopReceiptsRepository;
import com.neoris.ej10PracticasDani.usecases.FindByCarRegistrationWorkshopReceiptUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindByCarRegistrationWorkshopReceiptUseCaseImpl implements FindByCarRegistrationWorkshopReceiptUseCase {
    //Aquí se encuentra la lógica de negocio y las operaciones necesarias para llevar a cabo los casos de uso

    private WorkshopReceiptsRepository workshopReceiptsRepository;

    public FindByCarRegistrationWorkshopReceiptUseCaseImpl(WorkshopReceiptsRepository workshopReceiptsRepository) {
        this.workshopReceiptsRepository = workshopReceiptsRepository;
    }

    @Override
    public List<WorkshopReceipt> findByCarRegistrationWorkshopReceipt(String carRegistration) {
        return workshopReceiptsRepository.findByCarRegistration(carRegistration);
    }
}
