package br.com.mrocha.dao.factory;
import br.com.mrocha.domain.Produto;
import br.com.mrocha.domain.ProdutoQuantidade;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoQuantidadeFactory {

    public static ProdutoQuantidade convert(ResultSet rs) throws SQLException {
        Produto produto = ProdutoFactory.convert(rs);
        ProdutoQuantidade prodQnt = new ProdutoQuantidade();
        prodQnt.setProduto(produto);
        prodQnt.setId(rs.getLong("id"));
        prodQnt.setQuantidade(rs.getInt("quantidade"));
        prodQnt.setValorTotal(rs.getBigDecimal("valor_total"));
        return prodQnt;
    }
}