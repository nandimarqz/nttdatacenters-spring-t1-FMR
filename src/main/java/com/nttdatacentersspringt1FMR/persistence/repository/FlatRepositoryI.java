package com.nttdatacentersspringt1FMR.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdatacentersspringt1FMR.persistence.Flat;

/**
 * Repositorio del piso
 * 
 * @author nandi
 *
 */
@Repository
public interface FlatRepositoryI extends JpaRepository<Flat, Long> {

}
