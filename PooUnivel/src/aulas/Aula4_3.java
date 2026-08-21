package aulas;

import java.awt.*;
import javax.swing.*;

public class Aula4_3 extends JFrame {

    JButton btn1;
    JButton btn2;
    JButton btn3;
    JLabel labelMensagem;

    public Aula4_3() {

        setTitle("Cadastro de Aluno");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        btn1 = new JButton("Topo");
        btn2 = new JButton("Centro");
        btn3 = new JButton("Esquerda");

        labelMensagem = new JLabel("BorderLayout", SwingConstants.CENTER);

        painel.add(btn1, BorderLayout.NORTH);
        painel.add(btn2, BorderLayout.CENTER);
        painel.add(btn3, BorderLayout.WEST);
        painel.add(labelMensagem, BorderLayout.SOUTH);

        btn1.addActionListener(e -> {
            labelMensagem.setText("Você clicou no Topo");
        });

        btn2.addActionListener(e -> {
            labelMensagem.setText("Você clicou no Centro");
        });

        btn3.addActionListener(e -> {
            labelMensagem.setText("Você clicou na Esquerda");
        });

        add(painel);
    }

    public static void main(String[] args) {
        new Aula4_3().setVisible(true);
    }
}