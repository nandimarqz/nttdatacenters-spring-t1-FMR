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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 * Clase que representa los pisos en BBDD
 * 
 * @author nandi
 *
 */
@Entity
@Table(name="NTTDATA_SPRING_T1_PISO")
public class Flat extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** Id del piso */
	private Long flatId;
	
	/** Numero del piso */
	private Integer number;
	
	/**Planta a la que pertence el piso*/
	private Floor floor;
	
	/** Lista de personas que viven en el piso */
	private List<Person> people;
	
	/**
	 * Devuelve el id del piso
	 * 
	 * @return Long
	 */
	@Column(name = "FLAT_ID")
	@Id
	@GeneratedValue(generator = "NNTDATA_SEC")
	@SequenceGenerator(name = "NNTDATA_SEC", sequenceName = "NNTDATA_FLAT_SEC", allocationSize = 1)
	public Long getFlatId() {
		return flatId;
	}

	/**
	 * Devuelve la listas de personas que viven en el piso
	 * 
	 * @return Lista de personas
	 */
	@OneToMany(mappedBy = "flat",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	public List<Person> getPeople() {
		return people;
	}


	/**
	 * Establece las personas del piso por la lista pasado por parametro
	 * 
	 * @param people
	 */
	public void setPeople(List<Person> people) {
		this.people = people;
	}


	/**
	 * Establece el id del piso por el id pasado por parametro
	 * 
	 * @param flatId
	 */
	public void setFlatId(Long flatId) {
		this.flatId = flatId;
	}


	/**
	 * Devuelve el numero del piso
	 * 
	 * @return Integer
	 */
	@Column(name = "FLAT_NUMBER")
	public Integer getNumber() {
		return number;
	}


	/**
	 * Establece el numero de del piso por el numero pasado por parametro
	 * 
	 * @param number
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}


	/**
	 * Devuelve la planta a la que pertenece el piso
	 * 
	 * @return Floor
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FLOOR_ID")
	public Floor getFloor() {
		return floor;
	}



	/**
	 * Establece la planta del piso por la planta pasada por parametro
	 * 
	 * @param floor
	 */
	public void setFloor(Floor floor) {
		this.floor = floor;
	}



	@Transient
	@Override
	public Long getId() {

		return this.getFlatId();
	}

}
