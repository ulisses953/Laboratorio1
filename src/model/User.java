package model;

public class User {
    private long id;
    private String nome;
    private String cpf;
    private String idade;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }
    public User(long id, String nome, String cpf, String idade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
    public User() {
    }
    public User(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
}
