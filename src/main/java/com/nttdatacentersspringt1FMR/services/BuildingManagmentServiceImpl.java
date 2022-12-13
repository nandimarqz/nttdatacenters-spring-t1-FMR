package com.nttdatacentersspringt1FMR.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdatacentersspringt1FMR.persistence.Flat;
import com.nttdatacentersspringt1FMR.persistence.Floor;
import com.nttdatacentersspringt1FMR.persistence.Person;
import com.nttdatacentersspringt1FMR.persistence.repository.FloorRepositoryI;

/**
 * Implementacion del servicio de gestion del edificio
 * 
 * @author nandi
 *
 */
@Service
public class BuildingManagmentServiceImpl implements BuildingManagmentServiceI {

	/** Repositorio de los pisos */
	@Autowired
	FloorRepositoryI floorRep;

	/** Logger para la clase */
	private static final Logger BMSILOG = LoggerFactory.getLogger(BuildingManagmentServiceImpl.class);

	@Override
	public String showInHabitants() {

		BMSILOG.debug("Inicio del metodo");

		List<Floor> floors = floorRep.findAll();// Guarda todas las plantas en una variable
		StringBuilder str = new StringBuilder();// StringBuilder para construir el string

		str.append("\nHabitantes del edificio");

		// Recorre las plantas
		for (Floor f : floors) {

			str.append("\nPlanta numero: " + f.getNumber());

			// Recorre los pisos
			for (Flat flat : f.getFlats()) {

				str.append("\n\tPiso numero: " + flat.getNumber());

				str.append("\n\tHabitantes:");

				// Recorre los habitantes del piso
				for (Person p : flat.getPeople()) {

					str.append("\n\t\t" + p);

				}

			}

		}

		BMSILOG.debug("Fin del metodo");
		return str.toString();
	}

}
