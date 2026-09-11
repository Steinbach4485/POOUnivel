package aulas.aula6;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class CadastroAlunos extends JFrame {

    private ArrayList<Aluno> alunos = new ArrayList<>();

    private JTextField txtNome;
    private JTextField txtIdade;
    private JButton btnCadastrar;
    private JButton btnListar;
    private JTextArea area;

    public CadastroAlunos() {

        setTitle("Cadastro de Alunos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        add(txtIdade);

        btnCadastrar = new JButton("Cadastrar");
        btnListar = new JButton("Listar");

        add(btnCadastrar);
        add(btnListar);

        area = new JTextArea();
        area.setEditable(false);

        add(new JScrollPane(area));

        btnCadastrar.addActionListener(e -> cadastrarAluno());

        btnListar.addActionListener(e -> listarAlunos());
    }

    private void cadastrarAluno() {

        try {
            String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());

            // O seu Aluno precisa de nome, idade e curso
            Aluno aluno = new Aluno(nome, idade, "TADS");

            alunos.add(aluno);

            JOptionPane.showMessageDialog(this, "Aluno cadastrado!");

            txtNome.setText("");
            txtIdade.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite uma idade válida!");
        }
    }

    private void listarAlunos() {

        area.setText("");

        for (Aluno aluno : alunos) {
            area.append(aluno.apresentar() + "\n");
        }
    }

    public static void main(String[] args) {

        CadastroAlunos tela = new CadastroAlunos();

        tela.setVisible(true);
    }
}