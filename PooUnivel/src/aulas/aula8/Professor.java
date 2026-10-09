package aulas.aula8;

public class Professor extends Pessoa {

    private String disciplina;
    private double salario;

    public Professor(String nome, String telefone,
                     String disciplina, double salario) {

        super(nome, telefone);
        this.disciplina = disciplina;
        this.salario = salario;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public double getSalario() {
        return salario;
    }
}