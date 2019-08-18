package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Produto;
import com.example.demo.repositories.ProdutoRepository;


@RestController
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@CrossOrigin
	@GetMapping
	public List<Produto> index() {
		return produtoRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Optional<Produto> show(@PathVariable("id") Long id) {
		return produtoRepository.findById(id);
	}
	
	@CrossOrigin
	@PostMapping
	public void create(@RequestBody Produto produto) {
		produtoRepository.save(produto);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Long id, @RequestBody Produto produtoNovo) {
        Optional<Produto> produto = produtoRepository.findById(id);
        
        if (!produto.isPresent()) {
        	return;
        }
        
        produtoNovo.setId(id);
        
        produtoRepository.save(produtoNovo);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		produtoRepository.deleteById(id);
	}
}
