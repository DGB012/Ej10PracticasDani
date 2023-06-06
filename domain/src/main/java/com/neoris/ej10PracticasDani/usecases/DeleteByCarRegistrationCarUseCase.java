package com.neoris.ej10PracticasDani.usecases;

public interface DeleteByCarRegistrationCarUseCase {
    //Interfaz en la que indicamos que metodo vamos a utilizar en
    // el controller de infrastructure y vamos a implementar en
    // la carpeta application en los casos de uso
    void deleteByCarRegistration(String carRegistration);
}
