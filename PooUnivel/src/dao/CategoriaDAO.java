
package dao;

import model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public boolean cadastrar(Categoria categoria) throws SQLException {

        String sql = "INSERT INTO categorias (nome, descricao) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());

            return stmt.executeUpdate() > 0;
        }
    }

    public List<Categoria> listar() throws SQLException {

        List<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT * FROM categorias ORDER BY nome";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Categoria categoria = new Categoria(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao")
                );

                categorias.add(categoria);
            }
        }

        return categorias;
    }

    public boolean excluir(int id) throws SQLException {

        String sql = "DELETE FROM categorias WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;
        }
    }
}
