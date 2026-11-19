package controller;
import dao.ProdutoDAO;
import model.Produto;
import util.ResultadoCadastro;;



public class ProdutoController {
    
    private final ProdutoDAO pDAO = new ProdutoDAO();

    public ResultadoCadastro cadastrar(String nome, String marca, double preco) {

        Produto p = new Produto();

    
    }
}
