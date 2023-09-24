package service;

import model.Sessao;
import model.User;

public class ServiceSessao extends Exception {

    /**
     * Funcao q visa Reservar a cadeira para o cinema
     * 
     * @param coluna
     * @param linha
     * @param user
     * @return
     * @throws Exception
     */
    public User reservar(int coluna, char linha, User user, Sessao sessao) throws Exception {
        final int COLUNA = validadorColuna(coluna);
        final int LINHA = validadorLinha(linha);

        User[][] cadeiras = sessao.getCadeiras(); // pegamos o as cadeiras

        if (!validarCadeira(sessao, COLUNA, LINHA)) {
            throw new Exception("cadeira ocupada");
        }

        cadeiras[COLUNA][LINHA] = user;

        sessao.setCadeiras(cadeiras);

        return cadeiras[COLUNA][LINHA];
    }

    /**
     * 
     * @param coluna
     * @param linha
     * @param user
     * @param sessao
     * @return
     * @throws Exception
     */
    public boolean cancelar(int coluna, char linha, Sessao sessao) throws Exception {
        final int COLUNA = validadorColuna(coluna);
        final int LINHA = validadorLinha(linha);

        if (validarCadeira(sessao, COLUNA, LINHA)) {
            return false;
        }

        User[][] cadeiras = sessao.getCadeiras();

        cadeiras[COLUNA][LINHA] = null;

        sessao.setCadeiras(cadeiras);

        return true;
    }
    /**
     * 
     * @param coluna
     * @param linha
     * @param user
     * @param sessao
     * @return
     * @throws Exception
     */
    public boolean alterar(int coluna, char linha, User user, Sessao sessao)throws Exception{
        final int COLUNA = validadorColuna(coluna);
        final int LINHA = validadorLinha(linha);

        User[][] cadeiras = sessao.getCadeiras();

        cadeiras[COLUNA][LINHA] = user;

        sessao.setCadeiras(cadeiras);

        return true;
    }

    /***
     * 
     * @param linha
     * @return
     * @throws Exception
     */
    protected int validadorLinha(char linha) throws Exception {
        int intLinha = (int) linha;

        if (intLinha > 90) {
            intLinha -= 97;
        } else {
            intLinha -= 65;
        }
        if (0 <= intLinha && intLinha < 26) {
            return intLinha;
        } else {
            throw new Exception("valor da linha invalido");
        }
    }

    /**
     * 
     * @param coluna
     * @return
     * @throws Exception
     */
    protected int validadorColuna(int coluna) throws Exception {
        if (coluna < 1 || coluna > Sessao.colunas) {
            throw new Exception("valor da linha invalido");
        }
        return coluna - 1;
    }

    /**
     * Funcao que visa retornar se a caderira da sesao esta disponivel
     * 
     * @param sessao do filme
     * @param coluna da sessao
     * @param linha  da sessao
     * @return true = cadera desocupada, false = cadeira ocupada
     */
    public boolean validarCadeira(Sessao sessao, int coluna, int linha) {
        User[][] cadeiras = sessao.getCadeiras();
        return cadeiras[coluna][linha] == null;
    }
     
}
