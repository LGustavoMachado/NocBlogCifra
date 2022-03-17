package com.lg.NocBlog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lg.NocBlog.model.Estilo;

@Repository
public interface EstiloRepository extends JpaRepository<Estilo, Long>{
	
	public List<Estilo> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	public Optional<Estilo> findByDescricao(String descricao2);
	
}
