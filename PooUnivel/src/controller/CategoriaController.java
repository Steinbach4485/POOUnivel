
package controller;

import dao.CategoriaDAO;
import model.Categoria;
import java.sql.SQLException;
import java.util.List;

public class CategoriaController {

    private final CategoriaDAO dao = new CategoriaDAO();

    public boolean cadastrar(Categoria categoria) throws SQLException {

        if (categoria == null) {
            throw new IllegalArgumentException("Categoria invalida!");
        }

        if (categoria.getNome() == null || categoria.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Informe o nome da categoria!");
        }

        if (categoria.getNome().length() > 100) {
            throw new IllegalArgumentException("Nome muito grande!");
        }

        categoria.setNome(categoria.getNome().trim());

        return dao.cadastrar(categoria);
    }

    public List<Categoria> listar() throws SQLException {

        return dao.listar();
    }

    public boolean excluir(int id) throws SQLException {

        if (id <= 0) {
            throw new IllegalArgumentException("ID invalido!");
        }

        return dao.excluir(id);
    }
}
