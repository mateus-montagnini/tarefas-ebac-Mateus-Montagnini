package br.mrocha.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_carro")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "codigo", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "Modelo", length = 30, nullable = false)
    private String modelo;

    @Column(name = "Placa", length = 15, nullable = false, unique = true)
    private String placa;

    @Column(name = "ano_fabricacao", nullable = false)
    private Integer ano;

    @OneToOne
    @JoinColumn(name = "id_marca_fk",
        foreignKey = @ForeignKey(name = "fk_marca_carro"),
        referencedColumnName = "id")
    private Marca marca;

    @OneToMany
    @JoinColumn(name = "id_acessorio_fk",
            foreignKey = @ForeignKey(name = "fk_acessorio_carro"),
            referencedColumnName = "id")
    private List<Acessorio> acessorios;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public void add(Acessorio acessorio) {
        this.acessorios.add(acessorio);
    }
}
