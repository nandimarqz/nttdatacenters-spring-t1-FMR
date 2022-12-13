package com.nttdatacentersspringt1FMR.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 * Clase que representa las plantas en BBDD
 * 
 * @author nandi
 *
 */
@Entity
@Table(name="NTTDATA_SPRING_T1_PLANTA")
public class Floor extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/** Id de la planta */
	private Long floorId;
	
	/** Numero de la planta */
	private Integer number;
	
	/** Lista de pisos en la planta */
	private List<Flat> flats;
	
	
	/**
	 * Devuelve el id de la planta
	 * 
	 * @return Long
	 */
	@Column(name = "FLOOR_ID")
	@Id
	@GeneratedValue(generator = "NNTDATA_SEC")
	@SequenceGenerator(name = "NNTDATA_SEC", sequenceName = "NNTDATA_FLOOR_SEC", allocationSize = 1)
	public Long getFloorId() {
		return floorId;
	}


	/**
	 * Establece el id de la planta por el id pasado por parametro
	 * 
	 * @param floorId
	 */
	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}


	/**
	 * Devuelve el numero de la planta
	 * 
	 * @return Integer
	 */
	@Column(name = "FLOOR_NUMBER")
	public Integer getNumber() {
		return number;
	}


	/**
	 * Establece el numero de la planta por el numero pasado por parametro
	 * 
	 * @param number
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * Devuelve la lista de pisos que hay en la planta
	 * 
	 * @return Lista de pisos
	 */
	@OneToMany(mappedBy = "floor",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	public List<Flat> getFlats() {
		return flats;
	}


	/**
	 * Establece la listas de pisos de la planta por la lista pasada por parametro
	 * 
	 * @param flats
	 */
	public void setFlats(List<Flat> flats) {
		this.flats = flats;
	}


	@Transient
	@Override
	public Long getId() {

		return this.getFloorId();
	}
	
	
}
