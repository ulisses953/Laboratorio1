package model;

public class Sessao {
    public static final int colunas = 14;
    public static final int linhas = 12; 

    private long id;
    private User[][] cadeiras = new User[colunas][linhas];
    private String filmName;
    private String idade;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public static int getColunas() {
        return colunas;
    }
    public static int getLinhas() {
        return linhas;
    }
    public User[][] getCadeiras() {
        return cadeiras;
    }
    public void setCadeiras(User[][] cadeiras) {
        this.cadeiras = cadeiras;
    }
    public String getFilmName() {
        return filmName;
    }
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }
    


    
}
