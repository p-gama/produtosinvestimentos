package com.projetos.mentoria.produtosinvestimentos.service;

import com.projetos.mentoria.produtosinvestimentos.exception.ProdutoNaoEncontradoException;
import com.projetos.mentoria.produtosinvestimentos.model.Produto;
import com.projetos.mentoria.produtosinvestimentos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;


    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrarProduto (Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long codigoProduto) {
        return produtoRepository.findById(codigoProduto).orElseThrow(() ->
        new ProdutoNaoEncontradoException("Produto " + codigoProduto + " não encontrado"));
    }

    public void deletarProduto(Long codigoProduto) {
        Produto produto = produtoRepository.findById(codigoProduto).orElseThrow(() -> new ProdutoNaoEncontradoException("Produto " + codigoProduto + " não encontrado."));
        produtoRepository.delete(produto);
    }

    public Produto atualizarProduto(Long codigoProduto, Produto requestAtualizar) {
        Produto produto = produtoRepository.findById(codigoProduto).orElseThrow(() -> new ProdutoNaoEncontradoException("Produto " + codigoProduto + " não encontrado."));

        produto.setNomeProduto(requestAtualizar.getNomeProduto());
        produto.setTaxa(requestAtualizar.getTaxa());
        produto.setDataAbertura(requestAtualizar.getDataAbertura());
        produto.setDataVencimento(requestAtualizar.getDataVencimento());
        produto.setQuantidadeDiasLiquidez(requestAtualizar.getQuantidadeDiasLiquidez());
        produto.setValorResgateMinimo(requestAtualizar.getValorResgateMinimo());
        produto.setValorAplicacaoMinima(requestAtualizar.getValorAplicacaoMinima());

        return produtoRepository.save(produto);


    }
}




