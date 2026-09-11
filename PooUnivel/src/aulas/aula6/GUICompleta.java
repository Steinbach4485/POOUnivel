package aulas.aula6;

import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUICompleta {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Exemplo de GUI");
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        // Nome
        JLabel lblNome = new JLabel("Digite seu nome:");
        lblNome.setBounds(20, 20, 150, 20);
        frame.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(150, 20, 200, 20);
        frame.add(txtNome);

        // Sexo
        JRadioButton rbtnMasculino = new JRadioButton("Masculino");
        rbtnMasculino.setBounds(20, 60, 100, 25);

        JRadioButton rbtnFeminino = new JRadioButton("Feminino");
        rbtnFeminino.setBounds(130, 60, 100, 25);

        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(rbtnMasculino);
        grupoSexo.add(rbtnFeminino);

        frame.add(rbtnMasculino);
        frame.add(rbtnFeminino);

        // Profissão
        JCheckBox chkProgramador = new JCheckBox("Programador");
        chkProgramador.setBounds(20, 100, 120, 25);
        frame.add(chkProgramador);

        JCheckBox chkProfessor = new JCheckBox("Professor");
        chkProfessor.setBounds(200, 100, 120, 25);
        frame.add(chkProfessor);

        // Cores
        String[] cores = {"Vermelho", "Verde", "Azul"};

        JComboBox<String> cbxCores = new JComboBox<>(cores);
        cbxCores.setBounds(20, 140, 100, 25);
        frame.add(cbxCores);

        // Frutas
        String[] frutas = {"Maçã", "Banana", "Laranja"};

        JList<String> lstFrutas = new JList<>(frutas);
        lstFrutas.setBounds(200, 140, 100, 60);
        frame.add(lstFrutas);

        // Slider
        JSlider slider = new JSlider(0, 100, 50);
        slider.setBounds(20, 180, 200, 50);
        frame.add(slider);

        // Observação
        JTextArea jObservacao = new JTextArea();
        jObservacao.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(jObservacao);
        scrollPane.setBounds(20, 240, 330, 70);
        frame.add(scrollPane);

        // Imagem
        ImageIcon icon = new ImageIcon(
            "C:\\Users\\ESSILVA9\\Documents\\PooUnivel\\resources\\imagem1.JPEG"
        );

        JLabel lblIcone = new JLabel(icon);
        lblIcone.setBounds(250, 320, 100, 50);
        frame.add(lblIcone);

        // Botão
        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(20, 330, 100, 30);
        frame.add(btnEnviar);

        // Evento do botão
        btnEnviar.addActionListener(e -> {

            String nome = txtNome.getText();

            String sexo;

            if (rbtnMasculino.isSelected()) {
                sexo = "Masculino";
            } else if (rbtnFeminino.isSelected()) {
                sexo = "Feminino";
            } else {
                sexo = "Não selecionado";
            }

            String programador;

            if (chkProgramador.isSelected()) {
                programador = "Sim";
            } else {
                programador = "Não";
            }

            String professor;

            if (chkProfessor.isSelected()) {
                professor = "Sim";
            } else {
                professor = "Não";
            }

            String cor = (String) cbxCores.getSelectedItem();

            String fruta = lstFrutas.getSelectedValue();

            String observacao = jObservacao.getText();

            int valorSlider = slider.getValue();

            JOptionPane.showMessageDialog(
                frame,
                "Nome: " + nome
                + "\nSexo: " + sexo
                + "\nProgramador: " + programador
                + "\nProfessor: " + professor
                + "\nCor: " + cor
                + "\nFruta: " + fruta
                + "\nSlider: " + valorSlider
                + "\nObservação: " + observacao
            );
        });

        frame.setVisible(true);
    }
}
