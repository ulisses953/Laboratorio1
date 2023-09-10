package service;

import model.Sessao;
import model.User;

public class ServiceSessao extends Exception{
    private Sessao sessao = new Sessao();

    public User ReservarCadeira(int coluna, char linha, User user) throws Exception{
        User[][] cadeiras = sessao.getCadeiras();

        cadeiras[ValidatorColuna(coluna)][validatorLinha(linha)] = user;

        sessao.setCadeiras(cadeiras);

        return cadeiras[ValidatorColuna(linha)][validatorLinha(linha)];
    }
    
    protected int validatorLinha(char linha) throws Exception{
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
            throw new Exception("valor invalido");
        }
    }

    protected int ValidatorColuna(int coluna ){
        if(coluna < 1 || coluna > Sessao.colunas ){
            return -1;
        }
        return coluna-1;
    }
}
