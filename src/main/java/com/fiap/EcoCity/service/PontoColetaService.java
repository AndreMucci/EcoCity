package com.fiap.EcoCity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.EcoCity.model.PontoColeta;
import com.fiap.EcoCity.repository.PontoColetaRepository;

@Service
public class PontoColetaService {
	
	@Autowired
    private PontoColetaRepository pontoColetaRepository;

    public List<PontoColeta> listarPontosDeColeta() {
        return pontoColetaRepository.findAll();
    }

    public Optional<PontoColeta> buscarPontoDeColetaPorId(Long id) {
        return pontoColetaRepository.findById(id);
    }

    public List<PontoColeta> buscarPontosDeColetaPorBairro(String bairro) {
        return pontoColetaRepository.findByBairro(bairro);
    }

    public List<PontoColeta> buscarPontosDeColetaPorTipoMaterial(String tipoMaterial) {
        return pontoColetaRepository.findByTiposMateriaisAceitosContainingIgnoreCase(tipoMaterial);
    }

    public PontoColeta salvarPontoDeColeta(PontoColeta pontoColeta) {
        return pontoColetaRepository.save(pontoColeta);
    }

    public void deletarPontoDeColeta(Long id) {
        pontoColetaRepository.deleteById(id);
    }


}
