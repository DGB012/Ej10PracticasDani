La aplicación es una aplicación de ejemplo que muestra cómo implementar una arquitectura hexagonal en una aplicación de Spring Boot.
La arquitectura hexagonal, también conocida como arquitectura de puertos y adaptadores, se basa en el principio de separación de
preocupaciones y promueve la modularidad y la reutilización del código.

La aplicación consta de las siguientes capas principales:
*Capa de Dominio: Contiene las entidades del dominio y las interfaces de los repositorios, servicios y casos de uso.

*Capa de Aplicación: Contiene las implementaciones de los casos de uso y coordina las operaciones necesarias para
ejecutarlos. También puede contener mappers para convertir entre objetos de dominio y objetos de datos.

*Capa de Infraestructura: Contiene las implementaciones de los repositorios y otros componentes de infraestructura,
como el mapper.

					Configuración y Ejecución
1.Asegúrate de tener instalado Java y Maven en tu sistema.

2.Abre el proyecto en tu IDE preferido.

3.Ejecuta la aplicación desde boot/src/main/java/com/neoris/ej10PracticasDani/ej10PracticasDaniApplication.java

4.La aplicación estará disponible en la URL http://localhost:8080

5.Las funciones de la aplicación estarán en las siguientes Url:

/workshopReceipts		Muestra todos los recibos de un taller
/workshopReceipt/{carRegistration}	Busca los recibos de un coche por su matricula
/workshopReceipt/new		Crea un recibo con la siguiente estructura:
				{
        				"id": 1,
        				"carRegistration": "ABC123",
        				"startDate": "2023-05-24T00:00:00",
        				"endDate": "2020-05-25T00:00:00",
        				"priceOfPieces": 150.0,
        				"hourlyRate": 16.0,
        				"curr": "EUR",
        				"description": "Sustitucion de volante y homologación"
    				}
/workshopReceipt/update		Modifica el estado de un recibo por su id con la misma estructura que al crear un recibo
/workshopReceipt/delete/{id}		Elimina un recibo por su id


/cars				Muestra todos los coches que han pasado por el taller de un taller
/car/{carRegistration}		Busca un coche por su matricula
/car/new			Crea un coche con la siguiente estructura:
				{
        				"id": 1,
    					"brand": "Toyota",
    					"model": "Corolla",
    					"color": "Azul",
    					"carRegistration": "ABC123"
    				}
/car/update				Modifica un coche por su id con la misma estructura que al crear un coche
/car/delete/{carRegistration}		Elimina un recibo por su id
