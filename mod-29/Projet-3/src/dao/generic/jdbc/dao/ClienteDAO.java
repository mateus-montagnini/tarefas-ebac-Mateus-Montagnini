package dao.generic.jdbc.dao;

import dao.generic.jdbc.ConnectionFactory;
import domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {
    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO tb_cliente (id, codigo, nome) VALUES (nextval('sequence_cliente'),?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
            stm.setString(2, cliente.getNome());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            CloseConnection(connection, stm, null);
        }
    }

    @Override
    public Cliente consultar(String codigo) throws Exception {
            Connection connection = null;
            PreparedStatement stm = null;
            ResultSet rs = null;
            Cliente cliente = null;

            try {
                connection = ConnectionFactory.getConnection();
                String sql = "SELECT * FROM tb_cliente WHERE codigo = ?";
                stm = connection.prepareStatement(sql);
                stm.setString(1, codigo);
                rs = stm.executeQuery();

                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setId(rs.getLong("id"));
                    cliente.setCodigo(rs.getString("codigo"));
                    cliente.setNome(rs.getString("nome"));
                }
            } catch(Exception e) {
                throw e;
            } finally {
                CloseConnection(connection, stm, rs);
            }
            return cliente;
    }

    @Override
    public Integer excluir(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM tb_cliente WHERE codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            CloseConnection(connection, stm, null);
        }
    }

    @Override
    public Integer atualizar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE tb_cliente SET nome = ?, codigo = ? WHERE id = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getCodigo());
            stm.setLong(3, cliente.getId());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            CloseConnection(connection, stm, null);
        }
    }

    @Override
    public List<Cliente> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Cliente> list = new ArrayList<>();
        Cliente cliente = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM tb_cliente";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String cd = rs.getString("codigo");
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCodigo(cd);
                list.add(cliente);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            CloseConnection(connection, stm, rs);
        }
        return list;
    }

    private void CloseConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if(connection != null && !stm.isClosed()) {
                connection.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
