package com.fiap.EcoCity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private String bairro;
	private boolean assinante;
	private String preferenciaNotificacao; 
	private String horarioPreferencialNotificacao;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public boolean isAssinante() {
		return assinante;
	}
	public void setAssinante(boolean assinante) {
		this.assinante = assinante;
	} 
	public String getPreferenciaNotificacao() {
		return preferenciaNotificacao;
	}
	public void setPreferenciaNotificacao(String preferenciaNotificacao) {
		this.preferenciaNotificacao = preferenciaNotificacao;
	}
	public String getHorarioPreferencialNotificacao() {
		return horarioPreferencialNotificacao;
	}
	public void setHorarioPreferencialNotificacao(String horarioPreferencialNotificacao) {
		this.horarioPreferencialNotificacao = horarioPreferencialNotificacao;
	}
	
	
	

}
