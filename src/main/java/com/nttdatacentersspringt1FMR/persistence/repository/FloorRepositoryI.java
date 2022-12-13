package com.nttdatacentersspringt1FMR.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdatacentersspringt1FMR.persistence.Floor;

/**
 * Repositorio de la planta
 * 
 * @author nandi
 *
 */
@Repository
public interface FloorRepositoryI extends JpaRepository<Floor, Long> {

}
