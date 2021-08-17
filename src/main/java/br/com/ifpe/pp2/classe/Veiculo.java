package br.com.ifpe.pp2.classe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Veiculo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Pattern(regexp="^(A-E){3}\\-\\d{4}")
	@Column(length = 7, nullable = false)
	private String placa;
	@Enumerated(EnumType.STRING)
	@Column(length = 8, nullable = false)
	private TipoVeiculo tipo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public TipoVeiculo getTipo() {
		return tipo;
	}
	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}
	
	
	
}
