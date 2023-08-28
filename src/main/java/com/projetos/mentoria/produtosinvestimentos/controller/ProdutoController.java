package com.projetos.mentoria.produtosinvestimentos.controller;


import com.projetos.mentoria.produtosinvestimentos.dto.ProdutoDTO;
import com.projetos.mentoria.produtosinvestimentos.mapper.ProdutoMapper;
import com.projetos.mentoria.produtosinvestimentos.model.Produto;
import com.projetos.mentoria.produtosinvestimentos.repository.ProdutoRepository;
import com.projetos.mentoria.produtosinvestimentos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
@Validated
public class ProdutoController {

    private final ProdutoService service;
    private final ProdutoMapper mapper;

    @Autowired
    private ProdutoRepository repository;


        public ProdutoController(ProdutoMapper mapper, ProdutoService service) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = service.cadastrarProduto(mapper.toProduto(produtoDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toProdutoDTO(produto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<ProdutoDTO> listaProdutos = service.listarProdutos().stream()
                .map(mapper::toProdutoDTO).collect(Collectors.toList());
        return ResponseEntity.ok(listaProdutos);
    }
}
