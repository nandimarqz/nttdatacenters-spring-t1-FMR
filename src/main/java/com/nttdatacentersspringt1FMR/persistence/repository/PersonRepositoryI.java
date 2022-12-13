package com.nttdatacentersspringt1FMR.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdatacentersspringt1FMR.persistence.Person;

/**
 * Repositorio de la persona
 * 
 * @author nandi
 *
 */
@Repository
public interface PersonRepositoryI extends JpaRepository<Person, Long> {

	/**
	 * Devuelve la persona con el dni pasada por parametro
	 * 
	 * @param dni
	 * @return Person
	 */
	public Person findByDni(String dni);

	/**
	 * Devuelve una lista de las personas con el nombre y apellidos pasado por
	 * parametro
	 * 
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 * @return lista de personas
	 */
	public List<Person> findByNameAndFirstSurnameAndSecondSurname(String name, String firstSurname,
			String secondSurname);
}
