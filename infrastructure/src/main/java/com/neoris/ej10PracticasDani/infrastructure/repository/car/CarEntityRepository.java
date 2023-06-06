package com.neoris.ej10PracticasDani.infrastructure.repository.car;

import com.neoris.ej10PracticasDani.entities.Car;
import com.neoris.ej10PracticasDani.infrastructure.domain.entity.InMemoryCarRepositoryEntity;
import com.neoris.ej10PracticasDani.infrastructure.mapper.inmemory.InMemoryCarEntityMapper;
import com.neoris.ej10PracticasDani.infrastructure.repository.car.jpa.CarJpaRepository;
import com.neoris.ej10PracticasDani.repository.CarsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Utilizamos esta etiqueta para indicar que se trata de un repositorio.
public class CarEntityRepository implements CarsRepository {
    // Creamos la clase que implementa el interface que viene de la capa domain dentro de la
    // carpeta repository, donde hemos declarado los métodos que queremos utilizar.

    private CarJpaRepository carJpaRepository;
    private InMemoryCarEntityMapper inMemoryCarEntityMapper;

    public CarEntityRepository(CarJpaRepository carJpaRepository, InMemoryCarEntityMapper inMemoryCarEntityMapper) {
        this.carJpaRepository = carJpaRepository;
        this.inMemoryCarEntityMapper = inMemoryCarEntityMapper;
    }

    @Override
    public List<Car> findAll() {
        List<InMemoryCarRepositoryEntity> result = carJpaRepository.findAll();
        return inMemoryCarEntityMapper.toDomainEntityList(result);
    }

    @Override
    public Car findByCarRegistrationCar(String carRegistration) {
        InMemoryCarRepositoryEntity result = carJpaRepository.findByCarRegistration(carRegistration);
        return inMemoryCarEntityMapper.toDomainEntity(result);
    }

    @Override
    public Car createCar(Car newCar) {
        InMemoryCarRepositoryEntity result = carJpaRepository.save(inMemoryCarEntityMapper.fromDomainEntity(newCar));
        return inMemoryCarEntityMapper.toDomainEntity(result);
    }

    @Override
    public Car updateCar(Car car) {
        InMemoryCarRepositoryEntity result = carJpaRepository.save(inMemoryCarEntityMapper.fromDomainEntity(car));
        return inMemoryCarEntityMapper.toDomainEntity(result);
    }

    @Override
    public void deleteByCarRegistration(String carRegistration) {
        carJpaRepository.deleteByCarRegistration(carRegistration);
    }
}