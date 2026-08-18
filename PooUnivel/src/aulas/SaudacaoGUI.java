package aulas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SaudacaoGUI extends JFrame {

    private JTextField campoNome;
    private JButton botaoSaudar;
    private JLabel labelMensagem;

    public SaudacaoGUI() {

        setTitle("Programa de saudação");

        setSize(350, 150);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

        campoNome = new JTextField(20);

        botaoSaudar = new JButton("Saudar");

        labelMensagem = new JLabel("Digite seu nome e clique em Saudar");

        painel.add(new JLabel("Nome"));
        painel.add(campoNome);
        painel.add(botaoSaudar);
        painel.add(labelMensagem);

        // Coloca o painel dentro da janela
        add(painel);

        // Define o que acontece quando o botão for clicado
        botaoSaudar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = campoNome.getText().trim();

                if (nome.isEmpty()) {
                    labelMensagem.setText("Por favor, digite seu Nome");
                } else {
                    labelMensagem.setText(
                        "Olá, " + nome + "! Seja bem Vindo(a)!"
                    );
                }
            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            SaudacaoGUI janela = new SaudacaoGUI();

            janela.setVisible(true);
        });
    }
}
