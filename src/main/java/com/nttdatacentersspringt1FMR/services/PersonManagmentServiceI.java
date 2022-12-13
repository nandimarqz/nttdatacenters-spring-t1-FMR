package com.nttdatacentersspringt1FMR.services;

import java.util.List;

import com.nttdatacentersspringt1FMR.persistence.Person;

/**
 * Interfaz del servicio de gestion de las personas
 * 
 * @author nandi
 *
 */
public interface PersonManagmentServiceI {

	/**
	 * Añade la persona pasada por parametro a la BBDD
	 * 
	 * @param p
	 */
	public void add(Person p);

	/**
	 * Devuelve una lista con todas las personas de la BBDD
	 * 
	 * @return Lista de personas
	 */
	public List<Person> getAll();

	/**
	 * Borra la persona pasada por parametro
	 * 
	 * @param p
	 */
	public void delete(Person p);

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
	public List<Person> findByNameAndSurnames(String name, String firstSurname, String secondSurname);

	/**
	 * Actualiza la persona pasada por parametro
	 * 
	 * @param p
	 */
	public void update(Person p);
}
