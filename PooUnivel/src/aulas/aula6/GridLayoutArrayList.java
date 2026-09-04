
package aulas.aula6;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GridLayoutArrayList extends JFrame {

    private ArrayList<String> listaTarefas;

    private JTextField campoTarefa;
    private JTextArea areaTextoExibicao;
    private JButton botaoAdicionar;
    private JButton botaoLimpar;

    public GridLayoutArrayList() {

        listaTarefas = new ArrayList<>();

        setTitle("Gerenciador de Tarefas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 1, 10, 10));

        JPanel painelEntrada = new JPanel(new GridLayout(1, 2, 5, 5));

        JLabel labelTarefa = new JLabel("Nova Tarefa", SwingConstants.CENTER);
        campoTarefa = new JTextField();

        painelEntrada.add(labelTarefa);
        painelEntrada.add(campoTarefa);

        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 5, 5));

        botaoAdicionar = new JButton("Adicionar");
        botaoLimpar = new JButton("Limpar Tudo");

        painelBotoes.add(botaoAdicionar);
        painelBotoes.add(botaoLimpar);

        areaTextoExibicao = new JTextArea();
        areaTextoExibicao.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaTextoExibicao);

        add(painelEntrada);
        add(painelBotoes);
        add(scroll);

        botaoAdicionar.addActionListener(e -> {

            String tarefa = campoTarefa.getText();

            if (!tarefa.isEmpty()) {

                listaTarefas.add(tarefa);

                mostrarTarefas();

                campoTarefa.setText("");

                campoTarefa.requestFocus();

            } else {

                JOptionPane.showMessageDialog(
                    this,
                    "Digite uma tarefa!"
                );
            }
        });

        botaoLimpar.addActionListener(e -> {

            listaTarefas.clear();

            mostrarTarefas();
        });
    }

    private void mostrarTarefas() {

        areaTextoExibicao.setText("");

        int numero = 1;

        for (String tarefa : listaTarefas) {

            areaTextoExibicao.append(
                numero + " - " + tarefa + "\n"
            );

            numero++;
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            GridLayoutArrayList janela =
                new GridLayoutArrayList();

            janela.setVisible(true);
        });
    }
}
