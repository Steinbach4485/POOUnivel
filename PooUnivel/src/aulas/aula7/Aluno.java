package aulas.aula7;

public class Aluno extends Pessoa {

    private double nota; // encapsulamento

    public Aluno (String nome, double nota) {
        super(nome);
        this.nota = nota;
        }

        @Override //polimorfismo
        public String apresentar () {
            return "Aluno: " + getNome() +
            "\nNota: " + nota;
            }
    
}
