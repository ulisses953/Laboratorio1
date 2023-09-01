package model;

import java.time.LocalDate;

public class Sesao {
    private long id;
    private User[][] cadeiras;
    private String filme;
    private LocalDate dataFinal;
    private LocalDate dataInicial;
    
    public User addCadeira(char x, int y, User user){
        
        
        user[LetraParaNumero(x)][y] 
    }

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
    public LocalDate getDataFinal() {
        return dataFinal;
    }
    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }
    public LocalDate getDataInicial() {
        return dataInicial;
    }
    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }
    private int LetraParaNumero(char c){
       
    }
    
}
