package model;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import dao.PersistenceUtil;
import dao.ProdutoDAO;

@Entity
public class Produto {
	@Id		
	@GeneratedValue
	private long id;
	private String nome;
	private Double espaco;
	private Double valor;
	private int quantidade;
	

	public Produto(String nome, Double espaco, Double valor, int quantidade) {
		this.nome = nome;
		this.espaco = espaco;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	public Produto(){
		
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getEspaco() {
		return espaco;
	}
	public void setEspaco(Double espaco) {
		this.espaco = espaco;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "\nProduto [id=" + id + ", nome=" + nome + ", espaco=" + espaco + ", valor=" + valor + ", quantidade="
				+ quantidade + "]\n";
	}
	
	

}
