package com.fiap.EcoCity.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.EcoCity.model.Coleta;

@Repository
public interface ColetaRepository extends JpaRepository<Coleta, Long> {
	
	List<Coleta> findByBairro(String bairro);
    List<Coleta> findByDataHoraInicioAfterAndDataHoraFimBefore(LocalDateTime inicio, LocalDateTime fim);
    List<Coleta> findByTiposMateriaisColetadosContainingIgnoreCase(String tipoMaterial);
    List<Coleta> findByBairroAndDataHoraInicioAfter(String bairro, LocalDateTime dataHora);

}
