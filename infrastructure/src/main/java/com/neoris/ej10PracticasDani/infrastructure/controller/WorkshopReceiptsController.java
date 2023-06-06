package com.neoris.ej10PracticasDani.infrastructure.controller;

import com.neoris.ej10PracticasDani.entities.WorkshopReceipt;
import com.neoris.ej10PracticasDani.usecases.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Utilizamos esta etiqueta para indicar que es un controlador del servicio Rest
public class WorkshopReceiptsController {

    private FindAllWorkshopReceiptsUseCase findAllWorkshopReceiptsUseCase;  //Inyectamos las depencias de las interfaces
    // de los casos de uso que tenemos en elmódulo de application

    private FindByCarRegistrationWorkshopReceiptUseCase findByCarRegistrationWorkshopReceiptUseCase;

    private CreateWorkshopReceiptUseCase createWorkshopReceiptUseCase;

    private UpdateWorkshopReceiptUseCase updateWorkshopReceiptUseCase;

    private DeleteByIdWorkshopReceiptUseCase deleteByIdWorkshopReceiptUseCase;

    public WorkshopReceiptsController(FindAllWorkshopReceiptsUseCase findAllWorkshopReceiptsUseCase, FindByCarRegistrationWorkshopReceiptUseCase findByCarRegistrationWorkshopReceiptUseCase, CreateWorkshopReceiptUseCase createWorkshopReceiptUseCase, UpdateWorkshopReceiptUseCase updateWorkshopReceiptUseCase, DeleteByIdWorkshopReceiptUseCase deleteByIdWorkshopReceiptUseCase) {
        this.findAllWorkshopReceiptsUseCase = findAllWorkshopReceiptsUseCase;
        this.findByCarRegistrationWorkshopReceiptUseCase = findByCarRegistrationWorkshopReceiptUseCase;
        this.createWorkshopReceiptUseCase = createWorkshopReceiptUseCase;
        this.updateWorkshopReceiptUseCase = updateWorkshopReceiptUseCase;
        this.deleteByIdWorkshopReceiptUseCase = deleteByIdWorkshopReceiptUseCase;
    }

    @GetMapping(value = "/workshopReceipts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WorkshopReceipt>> getAllWorkshopReceipts() {
        return ResponseEntity.ok(findAllWorkshopReceiptsUseCase.findAll());
    }

    @GetMapping(value = "/workshopReceipt/{carRegistration}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WorkshopReceipt>> getByCarRegistration(@PathVariable String carRegistration) {
        return ResponseEntity.ok(findByCarRegistrationWorkshopReceiptUseCase.findByCarRegistrationWorkshopReceipt(carRegistration));
    }

    @PostMapping("/workshopReceipt/new")
    public ResponseEntity<WorkshopReceipt> createWorkshopReceipt(@RequestBody WorkshopReceipt newWorkshopReceipt) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createWorkshopReceiptUseCase.createWorkshopReceipt(newWorkshopReceipt));
    }

    @PutMapping("/workshopReceipt/update")
    public ResponseEntity<WorkshopReceipt> updateWorkshopReceipt(@RequestBody WorkshopReceipt workshopReceipt) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(updateWorkshopReceiptUseCase.updateWorkshopReceipt(workshopReceipt));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/workshopReceipt/delete/{id}")
    public ResponseEntity<WorkshopReceipt> deleteWorkshopReceipt(@PathVariable Integer id) {
        deleteByIdWorkshopReceiptUseCase.deleteByIdWorkshopReceipt(id);
        return ResponseEntity.noContent().build();
    }
}
