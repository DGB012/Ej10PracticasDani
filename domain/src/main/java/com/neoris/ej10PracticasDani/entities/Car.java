package com.neoris.ej10PracticasDani.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor //Generamos un constructor con lombok con todas las variables de la clase
@NoArgsConstructor  //Generamos un constructor con lombok sin variables
@Data               //Generamos los gatters y setters con lombok
public class Car {
    private Integer id;
    private String brand;
    private String model;
    private String color;
    private String carRegistration;
}
