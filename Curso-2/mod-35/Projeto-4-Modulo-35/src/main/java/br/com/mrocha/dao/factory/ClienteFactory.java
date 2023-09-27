package br.com.mrocha.dao.factory;

import br.com.mrocha.domain.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteFactory {

    public static Cliente convert(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getLong("id_cliente"));
        cliente.setNome(rs.getString(("nome")));
        cliente.setCpf(rs.getLong(("cpf")));
        cliente.setTel(rs.getLong(("tel")));
        cliente.setEnd(rs.getString(("endereco")));
        cliente.setNumero(rs.getInt(("numero")));
        cliente.setCidade(rs.getString(("cidade")));
        cliente.setEstado(rs.getString(("estado")));
        cliente.setCep(rs.getLong(("cep")));
        return cliente;
    }
}
