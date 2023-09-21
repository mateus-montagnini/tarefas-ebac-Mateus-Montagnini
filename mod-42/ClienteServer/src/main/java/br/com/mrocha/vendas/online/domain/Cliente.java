package br.com.mrocha.vendas.online.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_cliente")
public class Cliente {
}
