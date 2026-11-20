
package view;

import model.Aluno;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TelaPrincipal extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;

    private JTextField txtPesquisa;

    private ArrayList<Aluno> alunos = new ArrayList<>();

    public TelaPrincipal() {

        setTitle("Sistema de Cadastro de Alunos");
        setSize(700, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("GERENCIAMENTO DE ALUNOS");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        add(titulo, BorderLayout.NORTH);

        modelo = new DefaultTableModel(
            new Object[]{"Nome", "Curso", "Email"}, 0
        );

        tabela = new JTable(modelo);

        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel painel = new JPanel();

        txtPesquisa = new JTextField(15);

        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnExcluir = new JButton("Excluir");

        painel.add(txtPesquisa);
        painel.add(btnPesquisar);
        painel.add(btnCadastrar);
        painel.add(btnExcluir);

        add(painel, BorderLayout.SOUTH);

        btnCadastrar.addActionListener(e -> cadastrar());

        btnExcluir.addActionListener(e -> excluir());

        btnPesquisar.addActionListener(e -> pesquisar());

    }

    private void cadastrar() {

        TelaCadastroAluno tela = new TelaCadastroAluno(this);

        tela.setVisible(true);

        Aluno aluno = tela.getAluno();

        if (aluno != null) {

            alunos.add(aluno);

            atualizarTabela(alunos);

            JOptionPane.showMessageDialog(this,
                "Aluno cadastrado com sucesso!");

        }
    }

    private void excluir() {

        int linha = tabela.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this,
                "Selecione um aluno!");

            return;
        }

        alunos.remove(linha);

        atualizarTabela(alunos);

        JOptionPane.showMessageDialog(this,
            "Aluno removido com sucesso!");

    }

    private void pesquisar() {

        String pesquisa = txtPesquisa.getText().toLowerCase();

        ArrayList<Aluno> resultado = new ArrayList<>();

        for (Aluno aluno : alunos) {

            if (aluno.getNome().toLowerCase().contains(pesquisa)) {
                resultado.add(aluno);
            }
        }

        atualizarTabela(resultado);

    }

    private void atualizarTabela(ArrayList<Aluno> lista) {

        modelo.setRowCount(0);

        for (Aluno aluno : lista) {

            modelo.addRow(new Object[]{
                aluno.getNome(),
                aluno.getCurso(),
                aluno.getEmail()
            });

        }
    }

}
