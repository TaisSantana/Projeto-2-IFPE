package br.com.ifpe.pp2.classe;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class AulaPratica {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date data;
	@DateTimeFormat(pattern="HH:mm")
	private Date hora;
	
	@NotNull(message="O professor deve ser informado!")
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Professor professor;
	@NotNull(message="O aluno deve ser informado!")
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Aluno aluno;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	

}
