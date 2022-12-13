package com.nttdatacentersspringt1FMR.services;

import java.util.List;

import com.nttdatacentersspringt1FMR.persistence.Flat;

/**
 * Servicio de gestion de los pisos
 * 
 * @author nandi
 *
 */
public interface FlatManagmentServiceI {

	/**
	 * Añade el piso pasador por parametro
	 * 
	 * @param f
	 */
	public void add(Flat f);

	/**
	 * Devuelve todos los pisos de la BBDD
	 * 
	 * @return lista de pisos
	 */
	public List<Flat> getAll();

	/**
	 * Borra en la bbdd el piso pasado por parametro
	 * 
	 * @param f
	 */
	public void delete(Flat f);

	/**
	 * Actualiza el piso pasado por parametro
	 * 
	 * @param f
	 */
	public void update(Flat f);

}
