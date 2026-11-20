
package view;

import model.Aluno;
import javax.swing.*;
import java.awt.*;

public class TelaCadastroAluno extends JDialog {

    private JTextField txtNome;
    private JTextField txtCurso;
    private JTextField txtEmail;

    private Aluno aluno;

    public TelaCadastroAluno(JFrame tela) {

        super(tela, "Cadastrar Aluno", true);

        setSize(350, 250);
        setLocationRelativeTo(tela);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Curso:"));
        txtCurso = new JTextField();
        add(txtCurso);

        add(new JLabel("Email:"));
        txtEmail = new JTextField();
        add(txtEmail);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        add(btnSalvar);
        add(btnCancelar);

        btnSalvar.addActionListener(e -> salvar());

        btnCancelar.addActionListener(e -> dispose());
    }

    private void salvar() {

        String nome = txtNome.getText().trim();
        String curso = txtCurso.getText().trim();
        String email = txtEmail.getText().trim();

        if (nome.isEmpty() || curso.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Preencha todos os campos!");
            return;
        }

        aluno = new Aluno(nome, curso, email);

        dispose();
    }

    public Aluno getAluno() {
        return aluno;
    }

}
