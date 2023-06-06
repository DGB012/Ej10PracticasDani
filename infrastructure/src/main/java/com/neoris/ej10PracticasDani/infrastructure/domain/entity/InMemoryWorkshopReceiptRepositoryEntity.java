package com.neoris.ej10PracticasDani.infrastructure.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity                           //Definimos que esta clase es una estidad de negocio
@Table(name = "WORKSHOP_RECEIPTS ")    //Definimos el origen de los datos que se van a utilizar.
// Con el atributo namedefinimos el nombre de la tabla que estamos utilizando.
public class InMemoryWorkshopReceiptRepositoryEntity {

    @Id                                                 // Definimos la Primary Key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definimos la estrategia que va a utilizar la Primary Key
    @Column(name = "ID")                                // Definimos el nombre de la columna que vamos a utilizar.
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CAR_REGISTRATION")
    private InMemoryCarRepositoryEntity inMemoryCarRepositoryEntity;
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @Column(name = "END_DATE")
    private LocalDateTime endDate;
    @Column(name = "PRICE_OF_PIECES")
    private Double priceOfPieces;
    @Column(name = "HOURLY_RATE")
    private Double hourlyRate;
    @Column(name = "CURR")
    private String curr;
    @Column(name = "DESCRIPTION")
    private String description;

    //Generamos los getters y setters para acceder a las variables ya que son privadas

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InMemoryCarRepositoryEntity getInMemoryCarRepositoryEntity() {
        return inMemoryCarRepositoryEntity;
    }

    public void setInMemoryCarRepositoryEntity(InMemoryCarRepositoryEntity inMemoryCarRepositoryEntity) {
        this.inMemoryCarRepositoryEntity = inMemoryCarRepositoryEntity;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Double getPriceOfPieces() {
        return priceOfPieces;
    }

    public void setPriceOfPieces(Double priceOfPieces) {
        this.priceOfPieces = priceOfPieces;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}