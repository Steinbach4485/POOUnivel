
package aulas.aula6;

// HERANÇA
// Professor herda de Pessoa

public class Professor extends Pessoa {

    private String disciplina;

    public Professor(String nome, int idade, String disciplina) {

        super(nome, idade);

        this.disciplina = disciplina;
    }

    // POLIMORFISMO
    @Override
    public String apresentar() {

        return "Professor: " + getNome()
                + " | Idade: " + getIdade()
                + " | Disciplina: " + disciplina;
    }
}

