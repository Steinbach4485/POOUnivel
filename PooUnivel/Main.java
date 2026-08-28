import aulas.aula5.Cliente;
import aulas.aula5.LimiteInvalidoException;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        try {

            Cliente clienteTela = new Cliente(
                "Carlos Silva",
                "11999999999",
                2500.00
            );

            clienteTela.setVisible(true);

            clienteTela.alterarLimiteComTexto("-150.00");

        } catch (LimiteInvalidoException e) {

            JOptionPane.showMessageDialog(
                null,
                "Erro crítico ao iniciar tela: " + e.getMessage(),
                "Falha na Inicialização",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
