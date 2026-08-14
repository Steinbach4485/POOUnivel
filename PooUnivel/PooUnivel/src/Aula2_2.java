
import java.util.Scanner;

public class Aula2_2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);


        //Declaração das variaveis
        String nome;
        int idade;
        double altura;


        System.out.print("Digite seu nome: "); 
        nome = entrada.nextLine();

        System.out.print("Digite sua idade: ");
        idade = entrada.nextInt();

        System.out.print("Digite sua altura: ");
        altura = entrada.nextDouble();

        System.out.println("\n=== DADOS INFORMADOS === ");
        System.out.println("Nome" + nome);
        System.out.println("idade: " + idade + "anos");
        System.out.println("Altura: " + altura + "m");


        entrada.close(); 
    }
}
