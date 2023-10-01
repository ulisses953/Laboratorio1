package model;

public class Sessao {
    public static final int COLUNA = 14;
    public static final int LINHA = 12; 

    private long id;
    private User[][] cadeiras = new User[COLUNA][LINHA];
    private String NomeDoFilme;
    private String idade;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public User[][] getCadeiras() {
        return cadeiras;
    }
    public void setCadeiras(User[][] cadeiras) {
        this.cadeiras = cadeiras;
    }
    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }
    public String getNomeDoFilme() {
        return NomeDoFilme;
    }
    public void setNomeDoFilme(String nomeDoFilme) {
        NomeDoFilme = nomeDoFilme;
    }
    


    
}
