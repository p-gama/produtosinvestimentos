package com.projetos.mentoria.produtosinvestimentos.repository;

import com.projetos.mentoria.produtosinvestimentos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
