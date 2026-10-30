
package dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import util.Funcoes;
import util.ResultadoCadastro;

public class UsuarioDAO {
    
    public boolean autenticar(Usuario usuario) {

        String sql = "SELECT login, senha FROM usuarios " + 
        "WHERE login = ? AND senha = ?";

        try (Connection conn = Conexao.conectar();
    PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, usuario.getLogin());

        stmt.setString(2, Funcoes.gerarHashSHA256(usuario.getSenha()));

        ResultSet rs = stmt.executeQuery();

        return rs.next();
    } catch (SQLException e){
        System.out.println("Erro ao autenticar: " + e.getMessage());
        return false;
    }

}

    public boolean existeUsuario(String nomeUsuario) {

        String sql = "SELECT 1 FROM usuarios WHERE login = ?";

        try (Connection minhaConexao = Conexao.conectar();
        PreparedStatement stmt = minhaConexao.prepareStatement(sql)) {

            stmt.setString(1 , nomeUsuario);
            ResultSet rs = stmt.executeQuery();
        
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro ao verificar existencia de usuario:  " + e.getMessage());
            return false;
        }

    }

    public ResultadoCadastro inserir(Usuario usuario) {
        if (existeUsuario(usuario.getLogin())) {
            return ResultadoCadastro.JA_EXISTE;
        }

        String sql = "INSERT INTO usuarios " +
        "(login, senha, data_criacao, tipo, ativo, email) " +
        "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection minhaConexao = Conexao.conectar();
            PreparedStatement stmt = minhaConexao.prepareStatement(sql)) {

                stmt.setString(1, usuario.getLogin());
                stmt.setString(2,
                    Funcoes.gerarHashSHA256(usuario.getSenha()));
                stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                stmt.setString(4, "U"); //Tipo de usuario padrao (u = usuario)
                stmt.setString(5, "T"); //Ativo(t = true)
                stmt.setString(6, ""); //sem email

                stmt.executeUpdate();

                return ResultadoCadastro.SUCESSO;
            } catch (SQLException e) {
                System.out.println("Erro ao inserir usuario: " +
                    e.getMessage());
                return ResultadoCadastro.ERRO_BANCO;
            }//PARAMOS AQUI NA AULA DO DIA 22/10
    }

    public List<Usuario> listarTodos(){

        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios ORDER BY id";

        try (Connection conn = Conexao.conectar();
    PreparedStatement stmt = conn.prepareStatement(sql)) {

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setLogin(rs.getString("login"));
            u.setTipo(rs.getString("tipo"));
            u.setAtivo(rs.getString("ativo"));
            u.setDataCriacao(rs.getString("data_criacao"));
            u.setEmail(rs.getString("email"));

            lista.add(u);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = Conexao.conectar();
    PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);

        int r = stmt.executeUpdate();

        return r > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;

    }
    }

    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, id);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()){
                    Usuario u = new Usuario();

                    u.setId(rs.getInt("id"));
                    u.setLogin(rs.getString("login"));
                    u.setTipo(rs.getString("tipo"));
                    u.setAtivo(rs.getString("ativo"));
                    u.setDataCriacao(rs.getString("data_criacao"));
                    u.setEmail(rs.getString("email"));

                    return u;
                }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuario: " + e.getMessage());
        }

        return null;
    }

    public boolean gravar(Usuario u) {
        String sql = "UPDATE usuarios SET login = ?, tipo = ?, " +
        "ativo = ?, email = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, u.getLogin());
                stmt.setString(2, u.getTipo());
                stmt.setString(3, u.getAtivo());
                stmt.setString(4, u.getEmail());
                stmt.setInt(5, u.getId());

                stmt.executeUpdate();
                return true;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuario: " + e.getMessage());
            return false;
        }
    }

    public void atualizar() {
        listarTodos();
    }
}
