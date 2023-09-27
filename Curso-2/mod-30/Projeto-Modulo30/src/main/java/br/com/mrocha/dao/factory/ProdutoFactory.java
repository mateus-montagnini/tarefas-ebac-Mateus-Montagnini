package main.java.br.com.mrocha.dao.factory;

import main.java.br.com.mrocha.domain.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProdutoFactory {

	
	public static Produto convert(ResultSet rs) throws SQLException {
		Produto prod = new Produto();
		prod.setId(rs.getLong("id_produto"));
		prod.setCodigo(rs.getString("codigo"));
		prod.setNome(rs.getString("nome"));
		prod.setDescricao(rs.getString("descricao"));
		prod.setValor(rs.getBigDecimal("valor"));
		return prod;
	}
}
