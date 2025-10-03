package br.com.mozar7.marketplace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "cetegoria", length = 100, nullable = false)
    private String categoria;

    @Column(name = "status", length = 100, nullable = false)
    private String status;

    @Column(name = "imagem")
    private String imagem;
}
