package com.fiap.EcoCity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.EcoCity.model.PontoColeta;

@Repository
public interface PontoColetaRepository extends JpaRepository<PontoColeta, Long> {
	
	List<PontoColeta> findByBairro(String bairro);
    List<PontoColeta> findByTiposMateriaisAceitosContainingIgnoreCase(String tipoMaterial);

}
