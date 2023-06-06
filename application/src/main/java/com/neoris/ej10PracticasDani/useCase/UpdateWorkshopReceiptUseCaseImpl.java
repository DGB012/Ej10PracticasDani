package com.neoris.ej10PracticasDani.useCase;

import com.neoris.ej10PracticasDani.entities.WorkshopReceipt;
import com.neoris.ej10PracticasDani.repository.WorkshopReceiptsRepository;
import com.neoris.ej10PracticasDani.usecases.UpdateWorkshopReceiptUseCase;
import org.springframework.stereotype.Component;

@Component
public class UpdateWorkshopReceiptUseCaseImpl implements UpdateWorkshopReceiptUseCase {
    //Aquí se encuentra la lógica de negocio y las operaciones necesarias para llevar a cabo los casos de uso

    private WorkshopReceiptsRepository workshopReceiptsRepository;

    public UpdateWorkshopReceiptUseCaseImpl(WorkshopReceiptsRepository workshopReceiptsRepository) {
        this.workshopReceiptsRepository = workshopReceiptsRepository;
    }

    @Override
    public WorkshopReceipt updateWorkshopReceipt(WorkshopReceipt updatedWorkShopReceipt) {
        return workshopReceiptsRepository.updateWorkshopReceipts(updatedWorkShopReceipt);
    }
}
