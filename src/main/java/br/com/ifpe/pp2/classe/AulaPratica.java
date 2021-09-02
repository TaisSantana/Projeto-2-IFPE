package br.com.ifpe.pp2.classe;

import java.time.LocalDate;
import java.time.LocalTime;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class AulaPratica {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate data;
	//@DateTimeFormat(pattern="HH:mm")
	private LocalTime hora;
	
	@NotBlank(message="O professor deve ser informado!")
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Professor professor;
	@NotBlank(message="O aluno deve ser informado!")
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Aluno aluno;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
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
