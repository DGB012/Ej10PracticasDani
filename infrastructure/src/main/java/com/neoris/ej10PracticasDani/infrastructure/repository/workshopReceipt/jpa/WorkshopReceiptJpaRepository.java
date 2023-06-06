package com.neoris.ej10PracticasDani.infrastructure.repository.workshopReceipt.jpa;

import com.neoris.ej10PracticasDani.infrastructure.domain.entity.InMemoryWorkshopReceiptRepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Utilizamos esta etiqueta para indicar a Spring que esta interfaz es un repositorio
public interface WorkshopReceiptJpaRepository extends JpaRepository<InMemoryWorkshopReceiptRepositoryEntity, Integer> {
    // Extendemos de JpaRepository para utilizar todos los métodos que venga por defecto.

    @Query("SELECT wr FROM InMemoryWorkshopReceiptRepositoryEntity wr WHERE wr.inMemoryCarRepositoryEntity.carRegistration = :carRegistration ORDER BY wr.id")
    List<InMemoryWorkshopReceiptRepositoryEntity> findByCarRegistration(
            @Param("carRegistration") String carRegistration
    );
}
