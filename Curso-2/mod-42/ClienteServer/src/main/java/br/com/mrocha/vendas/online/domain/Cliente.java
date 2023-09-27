package br.com.mrocha.vendas.online.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Document(collection = "cliente")
@Data
@Builder
@Schema(name = "Cliente", description = "Cliente")
public class Cliente {

    @Id
    @Schema(description = "Identificador único")
    private Long id;

    @NotNull
    @Size(min = 1, max = 80)
    @Schema(description = "Nome")
    private String nome;

    @NotNull
    @Indexed(unique = true)
    @Schema(description = "CPF")
    private Long cpf;

    @NotNull
    @Schema(description = "Telefone")
    private Long telefone;

    @NotNull
    @Indexed(unique = true)
    @Schema(description = "Email")
    @Pattern(regexp = ".+@.+\\..+", message = "Email inválido")
    private String email;

    @NotNull
    @Schema(description = "Endereço")
    private String endereco;

    @NotNull
    @Schema(description = "Cidade")
    private String cidade;

    @NotNull
    @Schema(description = "Estado")
    private String estado;
}
