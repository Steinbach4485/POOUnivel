package model;

//criar no model

public class Usuario {
    
    private int id;
    private String login;
    private String senha;
    private String dataCriacao;
    private String ativo;
    private String tipo;
    private String email;


    public int getId() { //retorna id usuario
        return id;
    }

    public void setId(int id) { //define id usuario
        this.id = id;
    }

    

}
