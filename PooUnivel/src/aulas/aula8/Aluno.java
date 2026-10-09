package aulas.aula8;

public class Aluno extends Pessoa {

    private String matricula;
    private String curso;

    public Aluno(String nome, String telefone,
                 String matricula, String curso) {

        super(nome, telefone);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }
}