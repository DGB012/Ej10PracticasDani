package com.neoris.ej10PracticasDani.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor //Generamos un constructor con lombok con todas las variables de la clase
@NoArgsConstructor  //Generamos un constructor con lombok sin variables
@Data               //Generamos los gatters y setters con lombok
public class WorkshopReceipt {
    private Integer id;
    private String carRegistration;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double priceOfPieces;
    private Double hourlyRate;
    private String curr;
    private String description;
}
