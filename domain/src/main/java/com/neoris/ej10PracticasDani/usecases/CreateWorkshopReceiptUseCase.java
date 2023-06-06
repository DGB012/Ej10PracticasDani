package com.neoris.ej10PracticasDani.usecases;

import com.neoris.ej10PracticasDani.entities.WorkshopReceipt;

public interface CreateWorkshopReceiptUseCase {
    //Interfaz en la que indicamos que metodo vamos a utilizar en
    // el controller de infrastructure y vamos a implementar en
    // la carpeta application en los casos de uso
    WorkshopReceipt createWorkshopReceipt(WorkshopReceipt newWorkshopReceipt);
}
