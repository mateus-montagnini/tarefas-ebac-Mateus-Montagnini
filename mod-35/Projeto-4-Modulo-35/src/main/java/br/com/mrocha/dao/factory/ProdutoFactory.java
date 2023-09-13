package br.com.mrocha.dao.factory;

import br.com.mrocha.domain.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProdutoFactory {

	
	public static Produto convert(ResultSet rs) throws SQLException {
		Produto produto = new Produto();
		produto.setId(rs.getLong("id_produto"));
		produto.setCodigo(rs.getString("codigo"));
		produto.setNome(rs.getString("nome"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setValor(rs.getBigDecimal("valor"));
		return produto;
	}
}
