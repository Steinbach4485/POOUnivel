package aulas.aula7;

public abstract class Pessoa { // classe abstrata
    private String nome; //encapsulamento

    public Pessoa(String nome) { //construtor
        this.nome = nome;
    }

    public void setNome(String nome) {//setter
        this.nome = nome;
    }

    public String getNome() {//getter
        return nome;
    }

    public abstract String apresentar();
}
