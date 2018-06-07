package br.com.jlapp.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="tb_produto")
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="gen_produto")
    @SequenceGenerator(name="gen_produto", sequenceName="gen_produto", allocationSize=1)
	private int id;
	
	@Column
	private String descricao;
	
	@Column
	private int quantidade_minima;
	
	@Column
	private Timestamp data_cadastro;
	
	@Column
	private double valor;
	
	
	public int getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade_minima() {
		return quantidade_minima;
	}
	public void setQuantidade_minima(int quantidade_minima) {
		this.quantidade_minima = quantidade_minima;
	}
	public Timestamp getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Timestamp data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
