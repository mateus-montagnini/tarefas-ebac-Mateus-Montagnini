package br.com.mrocha.vendas.online.domain;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "produto")
@Data
@Builder
public class Produto {

    public enum Status {
        ATIVO, INATIVO;
    }

    @Id
    private String id;

    @NotNull
    @Indexed(unique = true)
    private String codigo;

    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    private BigDecimal valor;

    private Status status;
}
