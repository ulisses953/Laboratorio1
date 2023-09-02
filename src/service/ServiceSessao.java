package service;

import model.Sessao;
import model.User;

public class ServiceSessao {
    private Sessao sessao = new Sessao();

    public User ReservarCadeira(int coluna, char linha, User user){
        User[][] cadeiras = sessao.getCadeiras();

        cadeiras[ValidatorColuna(coluna)][validatorLinha(linha)] = user;

        sessao.setCadeiras(cadeiras);

        return cadeiras[ValidatorColuna(linha)][validatorLinha(linha)];
    }
    
    

    protected int validatorLinha(char linha){
         int intLinha = (int)linha;
        
        if(intLinha > 90){
            intLinha -= 97;
        }
        else{
            intLinha -= 65;
        }
        if (0 <= intLinha && intLinha < 26){
            return intLinha;
        }
        else{ 
            return -1;
        }
    }

    protected int ValidatorColuna(int coluna ){
        if(coluna < 1 || coluna > Sessao.colunas ){
            return -1;
        }
        return coluna-1;
    }
}
