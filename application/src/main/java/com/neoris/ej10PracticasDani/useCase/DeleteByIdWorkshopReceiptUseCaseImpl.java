package com.neoris.ej10PracticasDani.useCase;

import com.neoris.ej10PracticasDani.repository.WorkshopReceiptsRepository;
import com.neoris.ej10PracticasDani.usecases.DeleteByIdWorkshopReceiptUseCase;
import org.springframework.stereotype.Component;

@Component
public class DeleteByIdWorkshopReceiptUseCaseImpl implements DeleteByIdWorkshopReceiptUseCase {
    //Aquí se encuentra la lógica de negocio y las operaciones necesarias para llevar a cabo los casos de uso

    private WorkshopReceiptsRepository workshopReceiptsRepository;

    public DeleteByIdWorkshopReceiptUseCaseImpl(WorkshopReceiptsRepository workshopReceiptsRepository) {
        this.workshopReceiptsRepository = workshopReceiptsRepository;
    }

    @Override
    public void deleteByIdWorkshopReceipt(Integer id) {
        workshopReceiptsRepository.deleteById(id);
    }
}
