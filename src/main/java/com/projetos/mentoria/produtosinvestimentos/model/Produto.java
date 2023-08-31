package com.projetos.mentoria.produtosinvestimentos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Table(name="prod_invt")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_prod", unique = true, nullable = false)
    private Long codigoProduto;


    @NotBlank(message = "O campo não pode estar em branco")
    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "vlr_apl_min")
    private BigDecimal valorAplicacaoMinima;

    @Column(name = "vlr_res_min")
    private BigDecimal valorResgateMinimo;

    @Column(name = "dt_abrt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataAbertura;

    @Column(name = "dt_venc")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataVencimento;

    @Column(name = "taxa_prod")
    private  BigDecimal taxa;

    @Column(name = "qtde_dias_liq")
    private Integer quantidadeDiasLiquidez;
}
