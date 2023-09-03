package model;

import java.time.LocalDate;
import java.util.Date;

public class Sessao {
    public static final int colunas = 14;
    public static final int linhas = 12; 

    private long id;
    private User[][] cadeiras = new User[colunas][linhas];
    private String filme;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFilme() {
        return filme;
    }
    public void setFilme(String filme) {
        this.filme = filme;
    }
    public User[][] getCadeiras() {
        return cadeiras;
    }
    public void setCadeiras(User[][] cadeiras) {
        this.cadeiras = cadeiras;
    }
    
}
