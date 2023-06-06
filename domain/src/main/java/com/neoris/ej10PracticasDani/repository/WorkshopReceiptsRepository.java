package com.neoris.ej10PracticasDani.repository;

import com.neoris.ej10PracticasDani.entities.WorkshopReceipt;

import java.util.List;

public interface WorkshopReceiptsRepository {
    //Interfaz en la que indicamos que metodos vamos a utilizar en el repository de infrastructure

    List<WorkshopReceipt> findAll();

    List<WorkshopReceipt> findByCarRegistration(String carRegistration);

    WorkshopReceipt createWorkshopReceipts(WorkshopReceipt newWorkshopReceipt);

    WorkshopReceipt updateWorkshopReceipts(WorkshopReceipt WorkshopReceipt);

    void deleteById(Integer id);
}
