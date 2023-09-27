package br.com.mrocha.vendas.online.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class APIValidationError extends APISubError{

    private String object;

    private String field;

    private Object rejectedValue;

    private String message;

    APIValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}
