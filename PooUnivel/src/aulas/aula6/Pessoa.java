
package aulas.aula6;

// Classe abstrata
// Demonstra ABSTRAÇÃO e ENCAPSULAMENTO

public abstract class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public abstract String apresentar();
}

