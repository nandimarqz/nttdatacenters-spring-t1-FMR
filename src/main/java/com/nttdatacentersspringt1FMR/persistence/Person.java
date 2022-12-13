package com.nttdatacentersspringt1FMR.persistence;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="NTTDATA_SPRING_T1_PERSONA")
public class Person extends AbstractEntity implements Serializable  {
	

	private static final long serialVersionUID = 1L;

	private Long personId;
	
	/** Nombre del cliente */
	private String name;

	/** Primer apellido del cliente */
	private String firstSurname;

	/** Segundo apellido del cliente */
	private String secondSurname;

	/** DNI del cliente */
	private String dni;
	
	private Flat flat;



	/**
	 * Devuelve el id de la persona
	 * 
	 * @return Long
	 */
	@Column(name = "PERSON_ID")
	@Id
	@GeneratedValue(generator = "NNTDATA_SEC")
	@SequenceGenerator(name = "NNTDATA_SEC", sequenceName = "NNTDATA_PERSON_SEC", allocationSize = 1)
	public Long getPersonId() {
		return personId;
	}

	/**
	 * Establece el id de la persona por el id pasado por parametro
	 * 
	 * @param personId
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	/**
	 * Devuelve el nombre de la persona
	 * 
	 * @return String
	 */
	@Column(name="NAME")
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre de la persona por el pasado por parametro
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve el primer apellido de la persona
	 * 
	 * @return String
	 */
	@Column(name="APELLIDO1")
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * Establece el primer apellido de la persona por el apellido pasado por parametro
	 * 
	 * @param firstSurname
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * Devuelve el segundo apellido de la persona
	 * 
	 * @return String
	 */
	@Column(name="APELLIDO2")
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * Establece el segundo apellido de la persona por el apellido pasado por parametro
	 * 
	 * @param secondSurname
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * Devuelve el dni de la persona
	 * 
	 * @return String
	 */
	@Column(name="DNI", unique=true, nullable = false, length=9)
	public String getDni() {
		return dni;
	}

	/**
	 * Establece el dni de la persona por el DNI pasado por parametro
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Devuelve al piso al que pertenece la persona
	 * 
	 * @return Flat
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FLAT_ID")
	public Flat getFlat() {
		return flat;
	}

	
	/**
	 * Establece el piso por el piso pasado por parametro
	 * 
	 * @param flat
	 */
	public void setFlat(Flat flat) {
		this.flat = flat;
	}


	@Transient
	@Override
	public Long getId() {

		return this.getPersonId();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", firstSurname=" + firstSurname + ", secondSurname="
				+ secondSurname + ", dni=" + dni + ((this.flat != null) ? ", flat=" + flat.getNumber() + "]":"");
	}
	
	
}
