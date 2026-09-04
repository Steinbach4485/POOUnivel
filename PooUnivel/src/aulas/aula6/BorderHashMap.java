package aulas.aula6;
import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class BorderHashMap extends JFrame {

    private HashMap<Integer, String> produtos;

    private JTextField txtId;
    private JTextField txtNome;
    private JTextArea area;

    public BorderHashMap() {

        produtos = new HashMap<>();

        setTitle("Cadastro de produtos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel(
            "Cadastro de Produtos",
            SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        add(titulo, BorderLayout.NORTH);

        JPanel painel = new JPanel();

        painel.add(new JLabel("ID"));

        txtId = new JTextField(5);
        painel.add(txtId);

        painel.add(new JLabel("Produto:"));

        txtNome = new JTextField(15);
        painel.add(txtNome);

        add(painel, BorderLayout.CENTER);

        JPanel botoes = new JPanel();

        JButton cadastrar = new JButton("Cadastrar");
        JButton listar = new JButton("Listar");
        JButton remover = new JButton("Remover");

        botoes.add(cadastrar);
        botoes.add(listar);
        botoes.add(remover);

        add(botoes, BorderLayout.SOUTH);

        area = new JTextArea();
        area.setEditable(false);

        add(new JScrollPane(area), BorderLayout.EAST);

        cadastrar.addActionListener(e -> cadastrarProduto());
        listar.addActionListener(e -> listarProdutos());
        remover.addActionListener(e -> removerProduto());
    }

    private void cadastrarProduto() {

        int id = Integer.parseInt(txtId.getText());

        String nome = txtNome.getText();

        produtos.put(id, nome);

        JOptionPane.showMessageDialog(
            this,
            "Produto cadastrado!"
        );

        txtId.setText("");
        txtNome.setText("");
    }

    private void listarProdutos() {

        area.setText("");

        for (Integer id : produtos.keySet()) {

            String nome = produtos.get(id);

            area.append(
                "ID: " + id + " - Produto: " + nome + "\n"
            );
        }
    }

    private void removerProduto() {

        int id = Integer.parseInt(
            txtId.getText()
        );

        produtos.remove(id);

        JOptionPane.showMessageDialog(
            this,
            "Produto Removido!"
        );

        listarProdutos();
    }

    public static void main(String[] args) {

        BorderHashMap tela = new BorderHashMap();

        tela.setVisible(true);
    }
}

