package com.fiap.EcoCity.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.EcoCity.model.Coleta;
import com.fiap.EcoCity.service.ColetaService;

@RestController
@RequestMapping("/coletas")
public class ColetaController {
	
	@Autowired
    private ColetaService coletaService;

    @GetMapping
    public ResponseEntity<List<Coleta>> listarColetas() {
        List<Coleta> coletas = coletaService.listarColetas();
        return new ResponseEntity<>(coletas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coleta> buscarColetaPorId(@PathVariable Long id) {
        Optional<Coleta> coleta = coletaService.buscarColetaPorId(id);
        return coleta.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/bairro/{bairro}")
    public ResponseEntity<List<Coleta>> buscarColetasPorBairro(@PathVariable String bairro) {
        List<Coleta> coletas = coletaService.buscarColetasPorBairro(bairro);
        return new ResponseEntity<>(coletas, HttpStatus.OK);
    }

    @GetMapping("/material/{tipoMaterial}")
    public ResponseEntity<List<Coleta>> buscarColetasPorTipoMaterial(@PathVariable String tipoMaterial) {
        List<Coleta> coletas = coletaService.buscarColetasPorTipoMaterial(tipoMaterial);
        return new ResponseEntity<>(coletas, HttpStatus.OK);
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<Coleta>> buscarColetasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim) {
        List<Coleta> coletas = coletaService.buscarColetasPorPeriodo(inicio, fim);
        return new ResponseEntity<>(coletas, HttpStatus.OK);
    }

    @GetMapping("/futuras/{bairro}")
    public ResponseEntity<List<Coleta>> buscarColetasFuturasPorBairro(@PathVariable String bairro) {
        List<Coleta> coletas = coletaService.buscarColetasFuturasPorBairro(bairro);
        return new ResponseEntity<>(coletas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Coleta> criarColeta(@RequestBody Coleta coleta) {
        Coleta novaColeta = coletaService.salvarColeta(coleta);
        return new ResponseEntity<>(novaColeta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coleta> atualizarColeta(@PathVariable Long id, @RequestBody Coleta coletaAtualizada) {
        Optional<Coleta> coletaExistente = coletaService.buscarColetaPorId(id);
        if (coletaExistente.isPresent()) {
            coletaAtualizada.setId(id);
            Coleta coletaSalva = coletaService.salvarColeta(coletaAtualizada);
            return new ResponseEntity<>(coletaSalva, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarColeta(@PathVariable Long id) {
        if (coletaService.buscarColetaPorId(id).isPresent()) {
            coletaService.deletarColeta(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
