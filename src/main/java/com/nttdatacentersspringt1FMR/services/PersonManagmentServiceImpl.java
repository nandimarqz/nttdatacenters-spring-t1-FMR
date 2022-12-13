package com.nttdatacentersspringt1FMR.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdatacentersspringt1FMR.persistence.Person;
import com.nttdatacentersspringt1FMR.persistence.repository.PersonRepositoryI;

@Service
public class PersonManagmentServiceImpl implements PersonManagmentServiceI {

	/** Repositorio de las personas */
	@Autowired
	PersonRepositoryI pr;

	/** Logger para la clase */
	private static final Logger PMSILOG = LoggerFactory.getLogger(PersonManagmentServiceImpl.class);

	@Override
	public void add(Person p) {

		// Si la persona es distinta a null y el id es null entra en la condicion
		if (p != null && p.getPersonId() == null) {

			PMSILOG.debug("Se ha añadido una persona");

			pr.save(p);// Añade la persona

		}

	}

	@Override
	public List<Person> getAll() {

		PMSILOG.debug("Obteniendo todas las personas");
		// Devuelve todas las personas de la BBDD
		return pr.findAll();
	}

	@Override
	public void delete(Person p) {

		// Si la persona es distinto a null y su id tambien entra en la condicion
		if (p != null && p.getId() != null) {

			PMSILOG.debug("Borrando persona con DNI: {}", p.getDni());

			pr.delete(p);// Borra la persona

		} else {

			PMSILOG.error("No existe la persona que se quiere borrar");

		}

	}

	@Override
	public Person findByDni(String dni) {

		PMSILOG.debug("Obteniendo persona con dni: {} ", dni);

		// Devuelve la persona con el dni pasada por parametro
		return pr.findByDni(dni);
	}

	@Override
	public List<Person> findByNameAndSurnames(String name, String firstSurname, String secondSurname) {

		PMSILOG.debug("Obteniendo persona con nombre y apellidos: {}, {}{} ", name, firstSurname, secondSurname);

		// Devuelve una lista de personas con el nombre y apellidos pasados por
		// parametro
		return pr.findByNameAndFirstSurnameAndSecondSurname(name, firstSurname, secondSurname);
	}

	@Override
	public void update(Person p) {

		// Si la persona no es nula ni el id ni el dni entra en la condicion
		if (p != null && p.getId() != null && p.getDni() != null) {

			// Si existe una persona con el id entra en la condicon
			if (pr.existsById(p.getId())) {

				PMSILOG.debug("Actualizando persona con dni: {} ", p.getDni());

				pr.save(p);// Actualiza la persona

			} else {

				PMSILOG.error("La persona que se intenta actualizar no existe");

			}

		}

	}

}
