package com.neoris.ej10PracticasDani.infrastructure.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                           //Definimos que esta clase es una estidad de negocio
@Table(name = "CAR")    //Definimos el origen de los datos que se van a utilizar.
// Con el atributo namedefinimos el nombre de la tabla que estamos utilizando.
public class InMemoryCarRepositoryEntity {

    @Column(name = "ID")                                // Definimos el nombre de la columna que vamos a utilizar.
    private Integer id;
    @Column(name = "BRAND")
    private String brand;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "COLOR")
    private String color;
    @Id
    @Column(name = "CAR_REGISTRATION")
    private String carRegistration;

    //Generamos los getters y setters para acceder a las variables ya que son privadas
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarRegistration() {
        return carRegistration;
    }

    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }
}