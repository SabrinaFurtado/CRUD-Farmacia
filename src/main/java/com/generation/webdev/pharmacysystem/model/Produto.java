package com.generation.webdev.pharmacysystem.model;


import com.sun.istack.NotNull;
import javax.persistence.*;


@Entity
@Table(name = "tb_produto")
public class Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull //(message = "O atributo nome é obrigatório")
    private String nome;


    @NotNull //(message = "A descrição é obrigatória")
    //@Size(min = 10, max = 1000, message = "A descrição deve conter no minimo 10 caracteres e no máximo 1000")
    private String descricao;

    @NotNull
    private double preco;


    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public double getPreco() {
        return preco;
    }


    public void setPreco(double preco) {
        this.preco = preco;
    }


    public Categoria getCategoria() {
        return categoria;
    }


    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
