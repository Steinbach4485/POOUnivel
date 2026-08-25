package aulas.aula5;

public class LimiteInvalidoException extends RuntimeException {
    public LimiteInvalidoException(String mensagem){
        super(mensagem); //classe pai
    }
}
