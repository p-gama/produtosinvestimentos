package com.projetos.mentoria.produtosinvestimentos.mapper;

import com.projetos.mentoria.produtosinvestimentos.dto.ProdutoDTO;
import com.projetos.mentoria.produtosinvestimentos.model.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {


    Produto toProduto(ProdutoDTO produtoDTO);

    ProdutoDTO toProdutoDTO(Produto produto);

}


