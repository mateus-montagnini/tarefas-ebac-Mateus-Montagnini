package br.com.mrocha.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_produto")
    @SequenceGenerator(name = "sequence_produto", sequenceName = "sq_produto", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "nome", length = 60, nullable = false)
    private String nome;
    @Column(name = "descricao", length = 60, nullable = false)
    private String descricao;
    @Column(name = "preco", nullable = false)
    private Double preco;

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
