package aulas;

import javax.swing.*;

public class Aula4_1 extends JFrame {

    JTextField txtNome;
    JTextField txtEmail;
    JButton btnSalvar;

    public Aula4_1() {

        setTitle("Cadastro de Aluno");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();

        painel.add(new JLabel("Nome"));
        txtNome = new JTextField(20);
        painel.add(txtNome);

        painel.add(new JLabel("Email"));
        txtEmail = new JTextField(20);
        painel.add(txtEmail);

        btnSalvar = new JButton("Salvar");
        painel.add(btnSalvar);

        btnSalvar.addActionListener(e -> {

            String nome = txtNome.getText();
            String email = txtEmail.getText();

            JOptionPane.showMessageDialog(
                this,
                "Nome: " + nome + "\nEmail: " + email
            );
        });

        add(painel);
    }

    public static void main(String[] args) {
        new Aula4_1().setVisible(true);
    }
}
