package com.neoris.ej10PracticasDani.useCase;

import com.neoris.ej10PracticasDani.entities.WorkshopReceipt;
import com.neoris.ej10PracticasDani.repository.WorkshopReceiptsRepository;
import com.neoris.ej10PracticasDani.usecases.CreateWorkshopReceiptUseCase;
import org.springframework.stereotype.Component;

@Component
public class CreateWorkshopReceiptUseCaseImpl implements CreateWorkshopReceiptUseCase {
    //Aquí se encuentra la lógica de negocio y las operaciones necesarias para llevar a cabo los casos de uso
    private WorkshopReceiptsRepository workshopReceiptsRepository;

    public CreateWorkshopReceiptUseCaseImpl(WorkshopReceiptsRepository workshopReceiptsRepository) {
        this.workshopReceiptsRepository = workshopReceiptsRepository;
    }

    @Override
    public WorkshopReceipt createWorkshopReceipt(WorkshopReceipt newWorkshopReceipt) {
        return workshopReceiptsRepository.createWorkshopReceipts(newWorkshopReceipt);
    }
}
