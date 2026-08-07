import java.util.Scanner;

public class Aula2_1 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu nome: "); //imprime sem pular linha
        String nome = entrada.nextLine(); //NextLine de texto digitado no teclado

        System.out.println("Olá " + nome + "!"); //imprime e pula linha abaixo

        entrada.close(); //destruindo objeto
    }
}