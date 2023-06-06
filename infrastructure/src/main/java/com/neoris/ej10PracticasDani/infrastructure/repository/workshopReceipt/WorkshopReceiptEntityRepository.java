package com.neoris.ej10PracticasDani.infrastructure.repository.workshopReceipt;

import com.neoris.ej10PracticasDani.entities.WorkshopReceipt;
import com.neoris.ej10PracticasDani.infrastructure.domain.entity.InMemoryWorkshopReceiptRepositoryEntity;
import com.neoris.ej10PracticasDani.infrastructure.mapper.inmemory.InMemoryWorkshopReceiptEntityMapper;
import com.neoris.ej10PracticasDani.infrastructure.repository.workshopReceipt.jpa.WorkshopReceiptJpaRepository;
import com.neoris.ej10PracticasDani.repository.WorkshopReceiptsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Utilizamos esta etiqueta para indicar que se trata de un repositorio.
public class WorkshopReceiptEntityRepository implements WorkshopReceiptsRepository {
    // Creamos la clase que implementa el interface que viene de la capa domain dentro de la
    // carpeta repository, donde hemos declarado los métodos que queremos utilizar.

    private WorkshopReceiptJpaRepository workshopReceiptJpaRepository;
    private InMemoryWorkshopReceiptEntityMapper inMemoryWorkshopReceiptEntityMapper;

    public WorkshopReceiptEntityRepository(WorkshopReceiptJpaRepository workshopReceiptJpaRepository, InMemoryWorkshopReceiptEntityMapper inMemoryWorkshopReceiptEntityMapper) {
        this.workshopReceiptJpaRepository = workshopReceiptJpaRepository;
        this.inMemoryWorkshopReceiptEntityMapper = inMemoryWorkshopReceiptEntityMapper;
    }

    @Override
    public List<WorkshopReceipt> findAll() {
        List<InMemoryWorkshopReceiptRepositoryEntity> result = workshopReceiptJpaRepository.findAll();
        return inMemoryWorkshopReceiptEntityMapper.toDomainEntityList(result);
    }

    @Override
    public List<WorkshopReceipt> findByCarRegistration(String carRegistration) {
        List<InMemoryWorkshopReceiptRepositoryEntity> result = workshopReceiptJpaRepository.findByCarRegistration(carRegistration);
        return inMemoryWorkshopReceiptEntityMapper.toDomainEntityList(result);
    }

    @Override
    public WorkshopReceipt createWorkshopReceipts(WorkshopReceipt newWorkshopReceipt) {
        InMemoryWorkshopReceiptRepositoryEntity result = workshopReceiptJpaRepository.save(inMemoryWorkshopReceiptEntityMapper.fromDomainEntity(newWorkshopReceipt));
        return inMemoryWorkshopReceiptEntityMapper.toDomainEntity(result);
    }

    @Override
    public WorkshopReceipt updateWorkshopReceipts(WorkshopReceipt workshopReceipt) {
        InMemoryWorkshopReceiptRepositoryEntity result = workshopReceiptJpaRepository.save(inMemoryWorkshopReceiptEntityMapper.fromDomainEntity(workshopReceipt));
        return inMemoryWorkshopReceiptEntityMapper.toDomainEntity(result);
    }

    @Override
    public void deleteById(Integer id) {
        workshopReceiptJpaRepository.deleteById(id);
    }
}
