package br.com.jlapp.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.jlapp.enums.TipoMov;


@Entity
@Table(name="tb_movimento_estoque")
public class MovimentoEstoque {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Produto produto;
	
	@Column
	private Timestamp data_movimento;
	
	@Column
	private int quantidade;
	
	@Column
	private TipoMov tipo_movimentacao;
	
	
	public int getId() {
		return id;
	}
	
		public Timestamp getData_movimento() {
		return data_movimento;
	}
	public void setData_movimento(Timestamp data_movimento) {
		this.data_movimento = data_movimento;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public TipoMov getTipo_movimentacao() {
		return tipo_movimentacao;
	}
	public void setTipo_movimentacao(TipoMov tipo_movimentacao) {
		this.tipo_movimentacao = tipo_movimentacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
}
