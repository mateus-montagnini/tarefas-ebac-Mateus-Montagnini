package br.mrocha.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marca_seq")
    @SequenceGenerator(name = "marca_seq", sequenceName = "sq_marca", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "codigo", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "nome", length = 30, nullable = false)
    private String nome;

    @OneToMany
    private List<Carro> carros;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String marca) {
        this.nome = marca;
    }
}
