package com.neoris.ej10PracticasDani.infrastructure.repository.car.jpa;

import com.neoris.ej10PracticasDani.infrastructure.domain.entity.InMemoryCarRepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository //Utilizamos esta etiqueta para indicar a Spring que esta interfaz es un repositorio
public interface CarJpaRepository extends JpaRepository<InMemoryCarRepositoryEntity, String> {
    // Extendemos de JpaRepository para utilizar todos los métodos que venga por defecto.
    @Query("SELECT car FROM InMemoryCarRepositoryEntity car WHERE car.carRegistration = :carRegistration ORDER BY car.id")
    InMemoryCarRepositoryEntity findByCarRegistration(
            @Param("carRegistration") String carRegistration
    );
    @Transactional
    @Modifying
    @Query("DELETE FROM InMemoryCarRepositoryEntity car WHERE car.carRegistration = :carRegistration")
    void deleteByCarRegistration(
            @Param("carRegistration") String carRegistration
    );
}
