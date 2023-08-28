package com.projetos.mentoria.produtosinvestimentos.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import javax.persistence.*;
import javax.validation.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

 //   @NotBlank(message = "O campo não pode estar em branco")
    @Column(name = "vlr_apl_min")
    private BigDecimal valorAplicacaoMinima;

 //   @NotBlank(message = "O campo não pode estar em branco")
    @Column(name = "vlr_res_min")
    private BigDecimal valorResgateMinimo;

//    @NotBlank(message = "O campo não pode estar em branco")
    @Column(name = "dt_abrt")
    private LocalDateTime dataAbertura;

//    @NotBlank(message = "O campo não pode estar em branco")
    @Column(name = "dt_venc")
    private LocalDateTime dataVencimento;

 //   @NotBlank(message = "O campo não pode estar em branco")
    @Column(name = "taxa_prod")
    private  BigDecimal taxa;

  //  @NotBlank(message = "O campo não pode estar em branco")
    @Column(name = "qtde_dias_liq")
    private Integer quantidadeDiasLiquidez;
}
