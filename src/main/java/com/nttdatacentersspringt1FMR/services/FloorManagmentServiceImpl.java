package com.nttdatacentersspringt1FMR.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdatacentersspringt1FMR.persistence.Floor;
import com.nttdatacentersspringt1FMR.persistence.repository.FloorRepositoryI;

/**
 * Implementacion del servicio de gestion de plantas
 * 
 * @author nandi
 *
 */
@Service
public class FloorManagmentServiceImpl implements FloorManagmentServiceI {

	/** Repositorio de las plantas */
	@Autowired
	FloorRepositoryI fr;

	/** Logger para la clase */
	private static final Logger FLMSILOG = LoggerFactory.getLogger(FloorManagmentServiceImpl.class);

	@Override
	public void add(Floor f) {

		// Si la planta pasada por parametro es distinta a null y el id de la planta es
		// null entra en la condicion
		if (f != null && f.getFloorId() == null) {

			FLMSILOG.debug("Se ha añadido una planta");

			fr.save(f);// Guarda la planta

		} else {

			FLMSILOG.error("La planta pasado por parametro es nulo o tiene ID asignado");

		}

	}

	@Override
	public List<Floor> getAll() {

		FLMSILOG.debug("Obteniendo todas las plantas");

		// Devuelve todas las plantas de la BBDD
		return fr.findAll();
	}

	@Override
	public void delete(Floor f) {

		// si la planta pasada por parametro es distinta a null y el id de la planta es
		// distinto a null entra en la condicion
		if (f != null && f.getFloorId() != null) {

			FLMSILOG.debug("Borrando planta con numero:{}", f.getNumber());

			fr.delete(f);// Lo borra

		} else {

			FLMSILOG.error("La planta que se quiere borrar no existe");

		}

	}

	@Override
	public void update(Floor f) {

		// Si la planta pasada por parametro es distinto a null y su id es distinto a
		// null entra en la condicion
		if (f != null && f.getId() != null) {

			if (fr.existsById(f.getId())) {

				FLMSILOG.debug("Actualizando la planta con id: {}", f.getId());

				fr.save(f);// actualiza la planta

			} else {

				FLMSILOG.error("La planta que se intenta actualizar no existe");

			}

		}

	}

}
