package com.fiap.EcoCity.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.EcoCity.model.Coleta;
import com.fiap.EcoCity.repository.ColetaRepository;

@Service
public class ColetaService {
	
	@Autowired
    private ColetaRepository coletaRepository;

    public List<Coleta> listarColetas() {
        return coletaRepository.findAll();
    }

    public Optional<Coleta> buscarColetaPorId(Long id) {
        return coletaRepository.findById(id);
    }

    public List<Coleta> buscarColetasPorBairro(String bairro) {
        return coletaRepository.findByBairro(bairro);
    }

    public List<Coleta> buscarColetasPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return coletaRepository.findByDataHoraInicioAfterAndDataHoraFimBefore(inicio, fim);
    }

    public List<Coleta> buscarColetasPorTipoMaterial(String tipoMaterial) {
        return coletaRepository.findByTiposMateriaisColetadosContainingIgnoreCase(tipoMaterial);
    }

    public List<Coleta> buscarColetasFuturasPorBairro(String bairro) {
        return coletaRepository.findByBairroAndDataHoraInicioAfter(bairro, LocalDateTime.now());
    }

    public Coleta salvarColeta(Coleta coleta) {
        return coletaRepository.save(coleta);
    }

    public void deletarColeta(Long id) {
        coletaRepository.deleteById(id);
    }


}
