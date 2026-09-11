package aulas.aula7;

public class Professor extends Pessoa {

    private String disciplina; // encapsulamento

    public Professor (String nome, String disciplina) {
        super(nome);
        this.disciplina = disciplina;
        }

        @Override //polimorfismo
        public String apresentar () {
            return "Professor: " + getNome() +
            "\nNota: " + disciplina;
            }
    
}
