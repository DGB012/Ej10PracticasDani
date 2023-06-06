package com.neoris.ej10PracticasDani.infrastructure.controller;

import com.neoris.ej10PracticasDani.entities.WorkshopReceipt;
import com.neoris.ej10PracticasDani.usecases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WorkshopReceiptsControllerTest {

    @Mock
    FindAllWorkshopReceiptsUseCase findAllWorkshopReceiptsUseCase;

    @Mock
    FindByCarRegistrationWorkshopReceiptUseCase findByCarRegistrationWorkshopReceiptUseCase;

    @Mock
    CreateWorkshopReceiptUseCase createWorkshopReceiptUseCase;

    @Mock
    UpdateWorkshopReceiptUseCase updateWorkshopReceiptUseCase;

    @Mock
    DeleteByIdWorkshopReceiptUseCase deleteByIdWorkshopReceiptUseCase;

    @InjectMocks
    WorkshopReceiptsController workshopReceiptsController;

    WorkshopReceipt workshopReceipt1;
    WorkshopReceipt workshopReceipt2;

    List<WorkshopReceipt> workshopReceipts;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        workshopReceipt1 = new WorkshopReceipt(1, "6100CCH", LocalDateTime.now(), LocalDateTime.now(), 150.00, 15.00, "EUR",
                "Sustitucion de volante y homologación");
        workshopReceipt2 = new WorkshopReceipt(2, "6100CCH", LocalDateTime.now(), LocalDateTime.now(), 50.00, 15.00, "EUR",
                "Mantenimiento y cambio de filtros");
        workshopReceipts = Arrays.asList(workshopReceipt1, workshopReceipt2);
    }

    @Test
    void findAll() {
        when(findAllWorkshopReceiptsUseCase.findAll()).thenReturn(workshopReceipts);
        ResponseEntity<List<WorkshopReceipt>> result = workshopReceiptsController.getAllWorkshopReceipts();
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(workshopReceipts, result.getBody());
    }

    @Test
    void findByCarRegistration() {
        when(findByCarRegistrationWorkshopReceiptUseCase.findByCarRegistrationWorkshopReceipt("6100CCH")).thenReturn(workshopReceipts);
        ResponseEntity<List<WorkshopReceipt>> result = workshopReceiptsController.getByCarRegistration("6100CCH");
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(workshopReceipts, result.getBody());
    }

    @Test
    void createWorkshopReceipt() {
        WorkshopReceipt workshopReceipt3 = new WorkshopReceipt(3, "6100CCH", LocalDateTime.now(), LocalDateTime.now(), 50.00, 15.00, "EUR",
                "Mantenimiento y cambio de filtros");
        when(createWorkshopReceiptUseCase.createWorkshopReceipt(new WorkshopReceipt(3, "6100CCH", LocalDateTime.now(), LocalDateTime.now(), 50.00, 15.00, "EUR",
                "Mantenimiento y cambio de filtros"))).thenReturn(workshopReceipt3);
        ResponseEntity<WorkshopReceipt> result = workshopReceiptsController.createWorkshopReceipt(workshopReceipt3);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(workshopReceipt3, result.getBody());
    }

    @Test
    void updateWorkshopReceipt() {
        workshopReceipt2.setDescription("Solucion");
        when(updateWorkshopReceiptUseCase.updateWorkshopReceipt(workshopReceipt2)).thenReturn(workshopReceipt2);
        ResponseEntity<WorkshopReceipt> result = workshopReceiptsController.updateWorkshopReceipt(workshopReceipt2);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(workshopReceipt2, result.getBody());
    }

    @Test
    void deleteWorkshopReceipt() {
        ResponseEntity<WorkshopReceipt> result = workshopReceiptsController.deleteWorkshopReceipt(1);
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }
}
