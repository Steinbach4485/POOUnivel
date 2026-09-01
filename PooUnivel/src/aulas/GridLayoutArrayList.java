```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    }
}
```
