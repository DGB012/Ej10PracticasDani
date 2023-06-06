package com.neoris.ej10PracticasDani.infrastructure.mapper.inmemory;

import com.neoris.ej10PracticasDani.entities.Car;
import com.neoris.ej10PracticasDani.infrastructure.domain.entity.InMemoryCarRepositoryEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface InMemoryCarEntityMapper extends InMemoryEntityMapper<Car, InMemoryCarRepositoryEntity> {

    @Override
        //utilizamos los atributos source y target,
        // en el primero indicamos dedonde obtenemos la información (entidad de base de datos),
        // en el segundo donde queremos inyectarla (entidad de negocio).
    Car toDomainEntity(InMemoryCarRepositoryEntity inMemoryCarRepositoryEntity);
}