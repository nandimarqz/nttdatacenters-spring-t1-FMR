package com.nttdatacentersspringt1FMR.services;

import java.util.List;

import com.nttdatacentersspringt1FMR.persistence.Floor;

/**
 * Interfaz del servicio de gestion de las plantas
 * 
 * @author nandi
 *
 */
public interface FloorManagmentServiceI {

	/**
	 * Añade la planta a la BBDD
	 * 
	 * @param f
	 */
	public void add(Floor f);

	/**
	 * Devuelve todas las plantas
	 * 
	 * @return lista de todas las plantas
	 */
	public List<Floor> getAll();

	/**
	 * Borra el piso pasado por parametro en la BBDD
	 * 
	 * @param f
	 */
	public void delete(Floor f);

	/**
	 * Actualiza el piso pasado por parametro
	 * 
	 * @param f
	 */
	public void update(Floor f);
}
