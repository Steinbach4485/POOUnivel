package aulas.aula5;

public class Funcionario extends Pessoa {

    private double salario;
    private String cargo;

    public Funcionario(String nome, String telefone, double salario, String cargo) {
        super(nome, telefone);
        this.salario = salario;
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}


//criei a classe Funcionario, que herda da classe Pessoa  
//funcionario aproveita os atributos e metodos de nome e telefone da 
//e tambem possuiseus próprios atributos, como salario e cargo.