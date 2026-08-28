package aulas.aula5;

import javax.swing.JOptionPane;

public class Cliente extends Pessoa {

    private double limiteCredito;

    public Cliente(String nome, String telefone, double limiteCredito) {
        super(nome, telefone);
        setTitle("Cadastro de Cliente Comercial");
        setLimiteCredito(limiteCredito);
        configurarAcoesDosBotoes();
    }

    private void configurarAcoesDosBotoes() {

        btnIncluir.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                this,
                "Preparando formulário para novo cliente...",
                "Ação: Incluir",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        btnGravar.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                this,
                "Dados salvos com sucesso!\n"
                + "Cliente: " + getNome() + "\n"
                + "Telefone: " + getTelefone() + "\n"
                + "Limite: R$ " + String.format("%.2f", limiteCredito),
                "Ação: Gravar",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        btnExcluir.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir o cliente "
                + getNome() + "?",
                "Confirmação de Exclusão",
                JOptionPane.YES_NO_OPTION
            );

            if (resposta == JOptionPane.YES_OPTION) {
                System.out.println(
                    "Cliente " + getNome() + " excluído do banco simulado."
                );
            }
        });
    }

    public void setLimiteCredito(double limiteCredito) {
        if (limiteCredito < 0) {
            throw new LimiteInvalidoException(
                "O limite de crédito não pode ser negativo. Tentado: R$ "
                + limiteCredito
            );
        }

        this.limiteCredito = limiteCredito;
    }

    public void alterarLimiteComTexto(String textoLimite) {
        try {
            double novoLimite = Double.parseDouble(textoLimite);
            setLimiteCredito(novoLimite);

            JOptionPane.showMessageDialog(
                this,
                "Novo limite aplicado: R$ "
                + String.format("%.2f", novoLimite),
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this,
                "Erro: Digite apenas números válidos!",
                "Falha na Conversão",
                JOptionPane.ERROR_MESSAGE
            );

        } catch (LimiteInvalidoException e) {
            JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Regra Violada",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }
}
