package com.lg.NocBlog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lg.NocBlog.model.Estilo;
import com.lg.NocBlog.repository.EstiloRepository;

@RestController
@RequestMapping("/estilo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstiloController {
	
	@Autowired
	private EstiloRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Estilo>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estilo> getById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Estilo>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Estilo> postTema(@Valid @RequestBody Estilo tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Estilo> putTema(@Valid @RequestBody Estilo tema){
		return repository.findById(tema.getId()).map(resp -> {
			return ResponseEntity.ok().body(repository.save(tema));
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostagem(@PathVariable Long id){
		return repository.findById(id).map(resp -> {
			repository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}
}




















