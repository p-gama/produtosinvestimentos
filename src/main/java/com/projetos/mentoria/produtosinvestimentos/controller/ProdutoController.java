package com.projetos.mentoria.produtosinvestimentos.controller;


import com.projetos.mentoria.produtosinvestimentos.dto.ProdutoDTO;
import com.projetos.mentoria.produtosinvestimentos.exception.ProdutoNaoEncontradoException;
import com.projetos.mentoria.produtosinvestimentos.mapper.ProdutoMapper;
import com.projetos.mentoria.produtosinvestimentos.model.Produto;
import com.projetos.mentoria.produtosinvestimentos.repository.ProdutoRepository;
import com.projetos.mentoria.produtosinvestimentos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        Produto produto = service.cadastrarProduto(mapper.toProduto(produtoDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toProdutoDTO(produto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<ProdutoDTO> listaProdutos = service.listarProdutos().stream()
                .map(mapper::toProdutoDTO).collect(Collectors.toList());
        return ResponseEntity.ok(listaProdutos);
    }
    @GetMapping(path = "/{codigoProduto}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long codigoProduto) {
            try {
                ProdutoDTO produto = mapper.toProdutoDTO(service.buscarProdutoPorId(codigoProduto));
                return ResponseEntity.ok(produto);
            } catch (Exception ex) {
                throw new ProdutoNaoEncontradoException(ex.getMessage());
            }
    }

    @DeleteMapping(path = "/{codigoProduto}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletarMensagem(@PathVariable Long codigoProduto) {
        try {
            service.deletarProduto(codigoProduto);
            return new ResponseEntity<>((HttpStatus.NO_CONTENT));
        } catch (Exception ex) {
            throw new ProdutoNaoEncontradoException(ex.getMessage());
        }
    }

    @PutMapping(path = "/{codigoProduto}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long codigoProduto, @RequestBody Produto requestAtualizacao){
            try {
                ProdutoDTO produto = mapper.toProdutoDTO(requestAtualizacao);
                produto.setCodigoProduto(codigoProduto);
                Produto produtoAtualizado = service.atualizarProduto(codigoProduto, requestAtualizacao);
                return new ResponseEntity<>(mapper.toProdutoDTO(produtoAtualizado), HttpStatus.OK);
            } catch (Exception ex) {
                throw new ProdutoNaoEncontradoException(ex.getMessage());
            }

    }
}
