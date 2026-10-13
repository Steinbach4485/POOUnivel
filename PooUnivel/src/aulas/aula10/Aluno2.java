package aulas.aula10;

public class Aluno2 {
    
    String nome;
    int codigo;

    @Override 
    public String toString() {
        return "Código: " + codigo
            + "| Nome: " + nome;
    }
}

public class Main {

    public static void main (String[] args) {

        Aluno2 a1 = new Aluno2();
        Aluno2 a2 = new Aluno2();

        a1.nome = "Maria";
        a1.codigo = 10;
        a2.nome = "Maria";
        a2.codigo = 10;

        System.out.println(a1);
        System.out.println(a1.equals(a2));
        

    }
}
