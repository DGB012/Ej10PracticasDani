package com.neoris.ej10PracticasDani.useCase;

import com.neoris.ej10PracticasDani.entities.WorkshopReceipt;
import com.neoris.ej10PracticasDani.repository.WorkshopReceiptsRepository;
import com.neoris.ej10PracticasDani.usecases.FindAllWorkshopReceiptsUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllWorkshopReceiptsUseCaseImpl implements FindAllWorkshopReceiptsUseCase {
    //Aquí se encuentra la lógica de negocio y las operaciones necesarias para llevar a cabo los casos de uso

    private WorkshopReceiptsRepository workshopReceiptsRepository;

    public FindAllWorkshopReceiptsUseCaseImpl(WorkshopReceiptsRepository workshopReceiptsRepository) {
        this.workshopReceiptsRepository = workshopReceiptsRepository;
    }

    @Override
    public List<WorkshopReceipt> findAll() {
        return workshopReceiptsRepository.findAll();
    }
}
