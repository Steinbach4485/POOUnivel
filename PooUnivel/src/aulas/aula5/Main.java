package aulas.aula5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== MENU =====");
        System.out.println("1 - Consultar Cliente");
        System.out.println("2 - Consultar Funcionario");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();

        switch (opcao) {

            case 1:
                // Main antigo - Cliente
                try {
                    Cliente clienteTela = new Cliente(
                        "Carlos Silva",
                        "11999999999",
                        2500.00
                    );

                    clienteTela.setVisible(true);

                    clienteTela.alterarLimiteComTexto("-150.00");

                } catch (LimiteInvalidoException e) {
                    System.out.println(
                        "Erro crítico ao iniciar tela: " + e.getMessage()
                    );
                }
                break;

            case 2:
                // Main novo - Funcionario
                Funcionario funcionario = new Funcionario(
                    "João Silva",
                    "45999999999",
                    2500.00,
                    "Vendedor"
                );

                System.out.println("\n===== FUNCIONÁRIO =====");
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Telefone: " + funcionario.getTelefone());
                System.out.println("Cargo: " + funcionario.getCargo());
                System.out.println("Salário: R$ " + funcionario.getSalario());
                break;

            case 0:
                System.out.println("Programa encerrado.");
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }

        scanner.close();
    }
}