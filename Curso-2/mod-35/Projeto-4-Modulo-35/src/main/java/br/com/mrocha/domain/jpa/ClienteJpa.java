package br.com.mrocha.domain.jpa;

import br.com.mrocha.dao.Persistente;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_cliente")
public class ClienteJpa extends Persistence implements Persistente {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_sequence")
    @SequenceGenerator(name="cliente_sequence", sequenceName="sq_cliente", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "cpf", nullable = false)
    private Long cpf;

    @Column(name = "telefone", nullable = false)
    private Long tel;

    @Column(name = "endereco", nullable = false, length = 100)
    private String end;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Long getCpf() {
        return cpf;
    }
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    public Long getTel() {
        return tel;
    }
    public void setTel(Long tel) {
        this.tel = tel;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
