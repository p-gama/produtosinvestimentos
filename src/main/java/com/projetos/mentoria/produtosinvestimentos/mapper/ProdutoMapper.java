package com.projetos.mentoria.produtosinvestimentos.mapper;

import com.projetos.mentoria.produtosinvestimentos.dto.ProdutoDTO;
import com.projetos.mentoria.produtosinvestimentos.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {


    Produto toProduto(ProdutoDTO produtoDTO);

    ProdutoDTO toProdutoDTO(Produto produto);

}

//    default Produto toProduto(ProdutoDTO produtoDTO) {
//        Produto produto = new Produto();
//        produto.setCodigoProduto(produtoDTO.getCodigoProduto());
//        produto.setNomeProduto(produtoDTO.getNomeProduto());
//        produto.setDataAbertura(produtoDTO.getDataVencimento());
//        produto.setDataVencimento(produtoDTO.getDataVencimento());
//        produto.setTaxa(produtoDTO.getTaxa());
//        produto.setQuantidadeDiasLiquidez(produtoDTO.getQuantidadeDiasLiquidez());
//        produto.setValorResgateMinimo(produtoDTO.getValorResgateMinimo());
//        return produto;
//
//    }
//
//    default ProdutoDTO toProdutoDTO(Produto produto) {
//        ProdutoDTO produtoDTO = new ProdutoDTO();
//        produtoDTO.setCodigoProduto(produto.getCodigoProduto());
//        produtoDTO.setNomeProduto(produto.getNomeProduto());
//        produtoDTO.setDataAbertura(produto.getDataVencimento());
//        produtoDTO.setDataVencimento(produto.getDataVencimento());
//        produtoDTO.setTaxa(produto.getTaxa());
//        produtoDTO.setQuantidadeDiasLiquidez(produto.getQuantidadeDiasLiquidez());
//        produtoDTO.setValorResgateMinimo(produto.getValorResgateMinimo());
//        return produtoDTO;
//    }


