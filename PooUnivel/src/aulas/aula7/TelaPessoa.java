package aulas.aula7;

import javax.swing.*; // biblioteca gráfica

public class TelaPessoa extends JFrame {

    private JTextField txtNome;
    private JComboBox<String> cbTipo;
    private JTextField txtInfo;
    private JButton btnMostrar;

    public TelaPessoa() {

        setTitle("Cadastro");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 30, 80, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 30, 220, 25);
        add(txtNome);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 70, 80, 25);
        add(lblTipo);

        cbTipo = new JComboBox<>(
            new String[]{"Aluno", "Professor"}
        );

        cbTipo.setBounds(100, 70, 220, 25);
        add(cbTipo);

        JLabel lblInfo = new JLabel("Informação:");
        lblInfo.setBounds(30, 100, 80, 25);
        add(lblInfo);

        txtInfo = new JTextField();
        txtInfo.setEditable(false);
        txtInfo.setBounds(100, 100, 220, 25);
        add(txtInfo);

        btnMostrar = new JButton("Mostrar");
        btnMostrar.setBounds(130, 160, 120, 30);
        add(btnMostrar);

        btnMostrar.addActionListener(e -> mostrar());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrar() {

        String nome = txtNome.getText();
        String tipo = cbTipo.getSelectedItem().toString();

        Pessoa pessoa;

        if (tipo.equals("Aluno")) {

            pessoa = new Aluno(nome, 8.5);

        } else {

            pessoa = new Professor(nome, "Java");
        }

        txtInfo.setText(
            pessoa.apresentar().replace("\n", " - ")
        );
    }

    public static void main(String[] args) {
        new TelaPessoa();
    }
}