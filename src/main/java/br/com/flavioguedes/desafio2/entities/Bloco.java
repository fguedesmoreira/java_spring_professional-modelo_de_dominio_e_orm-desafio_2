package br.com.flavioguedes.desafio2.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_bloco")
public class Bloco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant inicio;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant fim;

	@ManyToOne
	@JoinColumn(name = "atividade_id", foreignKey = @ForeignKey(name = "fk_bloco_atividade"))
	private Atividade atividade;

	public Bloco() {
	}

	public Bloco(Integer id, Instant inicio, Instant fim, Atividade atividade) {
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
		this.atividade = atividade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloco other = (Bloco) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Bloco [id=" + id + ", inicio=" + inicio + ", fim=" + fim + ", atividade=" + atividade + "]";
	}

}