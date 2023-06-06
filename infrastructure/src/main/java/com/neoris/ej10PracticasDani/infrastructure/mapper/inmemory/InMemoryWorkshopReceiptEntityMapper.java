package com.neoris.ej10PracticasDani.infrastructure.mapper.inmemory;

import com.neoris.ej10PracticasDani.entities.WorkshopReceipt;
import com.neoris.ej10PracticasDani.infrastructure.domain.entity.InMemoryWorkshopReceiptRepositoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface InMemoryWorkshopReceiptEntityMapper extends InMemoryEntityMapper<WorkshopReceipt, InMemoryWorkshopReceiptRepositoryEntity> {

    @Override
    @Mapping(source = "inMemoryCarRepositoryEntity.carRegistration", target = "carRegistration")
        //utilizamos los atributos source y target,
        // en el primero indicamos de donde obtenemos la información (entidad de base de datos),
        // en el segundo donde queremos inyectarla (entidad de negocio).
    WorkshopReceipt toDomainEntity(InMemoryWorkshopReceiptRepositoryEntity inMemoryWorkshopReceiptRepositoryEntity);

    @Override
    @Mapping(source = "carRegistration", target = "inMemoryCarRepositoryEntity.carRegistration")
    InMemoryWorkshopReceiptRepositoryEntity fromDomainEntity(WorkshopReceipt workshopReceipt);
}