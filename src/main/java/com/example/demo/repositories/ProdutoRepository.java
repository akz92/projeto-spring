package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findByNomeContaining(String nome);
	public List<Produto> findByCategoria(String categoria);
	public List<Produto> valorBetween(Double valor1, Double valor2);

}