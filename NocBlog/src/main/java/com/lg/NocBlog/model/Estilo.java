package com.lg.NocBlog.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_estilos")
public class Estilo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Esse campo não pode ser vazio")
	@Size(min = 2, max = 50, message = ("Mínimo de 2 caracteres e o máximo 50"))
	private String descricao;
	
	@OneToMany(mappedBy = "estilo", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("estilo")
	private List<Postagem> postagem;
	
	public Estilo(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	public Estilo() {}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	
}











