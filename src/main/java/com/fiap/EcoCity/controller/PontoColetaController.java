package com.fiap.EcoCity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.EcoCity.model.PontoColeta;
import com.fiap.EcoCity.service.PontoColetaService;

@RestController
@RequestMapping("/pontoscoleta")
public class PontoColetaController {
	
	@Autowired
    private PontoColetaService pontoColetaService;

    @GetMapping
    public ResponseEntity<List<PontoColeta>> listarPontosDeColeta() {
        List<PontoColeta> pontos = pontoColetaService.listarPontosDeColeta();
        return new ResponseEntity<>(pontos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoColeta> buscarPontoDeColetaPorId(@PathVariable Long id) {
        Optional<PontoColeta> ponto = pontoColetaService.buscarPontoDeColetaPorId(id);
        return ponto.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/bairro/{bairro}")
    public ResponseEntity<List<PontoColeta>> buscarPontosDeColetaPorBairro(@PathVariable String bairro) {
        List<PontoColeta> pontos = pontoColetaService.buscarPontosDeColetaPorBairro(bairro);
        return new ResponseEntity<>(pontos, HttpStatus.OK);
    }

    @GetMapping("/material/{tipoMaterial}")
    public ResponseEntity<List<PontoColeta>> buscarPontosDeColetaPorTipoMaterial(@PathVariable String tipoMaterial) {
        List<PontoColeta> pontos = pontoColetaService.buscarPontosDeColetaPorTipoMaterial(tipoMaterial);
        return new ResponseEntity<>(pontos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PontoColeta> criarPontoDeColeta(@RequestBody PontoColeta pontoColeta) {
        PontoColeta novoPonto = pontoColetaService.salvarPontoDeColeta(pontoColeta);
        return new ResponseEntity<>(novoPonto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PontoColeta> atualizarPontoDeColeta(@PathVariable Long id, @RequestBody PontoColeta pontoColetaAtualizado) {
        Optional<PontoColeta> pontoExistente = pontoColetaService.buscarPontoDeColetaPorId(id);
        if (pontoExistente.isPresent()) {
            pontoColetaAtualizado.setId(id);
            PontoColeta pontoSalvo = pontoColetaService.salvarPontoDeColeta(pontoColetaAtualizado);
            return new ResponseEntity<>(pontoSalvo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPontoDeColeta(@PathVariable Long id) {
        if (pontoColetaService.buscarPontoDeColetaPorId(id).isPresent()) {
            pontoColetaService.deletarPontoDeColeta(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
