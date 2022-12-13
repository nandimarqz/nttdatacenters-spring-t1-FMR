package com.nttdatacentersspringt1FMR.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdatacentersspringt1FMR.persistence.Flat;
import com.nttdatacentersspringt1FMR.persistence.repository.FlatRepositoryI;

/**
 * Implementacion del servicio de gestion de los pisos
 * 
 * @author nandi
 *
 */
@Service
public class FlatManagmentServiceImpl implements FlatManagmentServiceI {

	/** Repositorio de los pisos */
	@Autowired
	FlatRepositoryI fr;

	/** Logger para la clase */
	private static final Logger FLMSILOG = LoggerFactory.getLogger(FlatManagmentServiceImpl.class);

	@Override
	public void add(Flat f) {

		// Si el piso pasado por parametro es distinto a null y el id es igual a null
		// Entra en la condicion
		if (f != null && f.getFlatId() == null) {

			FLMSILOG.debug("Se ha añadido un piso");

			fr.save(f);// Guarda el piso

		} else {

			FLMSILOG.error("El piso pasado por parametro es nulo o tiene ID asignado");

		}

	}

	@Override
	public List<Flat> getAll() {

		FLMSILOG.debug("Obteniendo todos los pisos");

		// Devuelve todos los pisos de la BBDD
		return fr.findAll();
	}

	@Override
	public void delete(Flat f) {

		// Si el piso pasado por parametro es distinto a null y el id tambien entra en
		// la condicion
		if (f != null && f.getFlatId() != null) {

			FLMSILOG.debug("Borrando piso con numero:{} en la planta: {}", f.getNumber(), f.getFloor().getNumber());

			fr.delete(f);// Borra el piso

		} else {

			FLMSILOG.error("El piso que se quiere borrar no existe");

		}

	}

	@Override
	public void update(Flat f) {

		// Si el piso pasado por parametro es distinto a null y el id entra en la
		// condicion
		if (f != null && f.getId() != null) {

			// Si existe el piso pasado por parametro entra en la condicion y lo actualiza
			if (fr.existsById(f.getId())) {

				FLMSILOG.debug("Actualizando piso con id: {}", f.getId());

				fr.save(f);

			} else {

				FLMSILOG.error("El piso que se intenta actualizar no existe");

			}

		}

	}

}
