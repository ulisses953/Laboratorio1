package service;

import model.Sessao;
import model.User;

public class ServiceSessao extends Exception {

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

    public boolean alterar(int coluna, char linha, User user, Sessao sessao) throws Exception {
        final int COLUNA = validadorColuna(coluna);
        final int LINHA = validadorLinha(linha);

        User[][] cadeiras = sessao.getCadeiras();

        cadeiras[COLUNA][LINHA] = user;

        sessao.setCadeiras(cadeiras);

        return true;
    }

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

    protected int validadorColuna(int coluna) throws Exception {
        if (coluna < 1 || coluna > Sessao.COLUNA) {
            throw new Exception("valor da linha invalido");
        }
        return coluna - 1;
    }

    public boolean validarCadeira(Sessao sessao, int coluna, int linha) {
        User[][] cadeiras = sessao.getCadeiras();
        return cadeiras[coluna][linha] == null;
    }

    public int cadeirasDisponivel(Sessao sessao) {
        User[][] cadeiras = sessao.getCadeiras();
        int cadeirasDisponivel = 0;
        for (int i = 0; i < cadeiras.length; i++) {
            for (int a = 0; a < cadeiras[i].length; a++) {
                if (cadeiras[i][a] == null) {
                    cadeirasDisponivel++;
                }
            }
        }
        return cadeirasDisponivel;
    }

    public int cadeirasNaoDisponivel(Sessao sessao) {
        User[][] cadeiras = sessao.getCadeiras();
        int cadeirasNaoDisponivel = 0;
        for (int i = 0; i < cadeiras.length; i++) {
            for (int a = 0; a < cadeiras[i].length; a++) {
                if (cadeiras[i][a] != null) {
                    cadeirasNaoDisponivel++;
                }
            }
        }
        return cadeirasNaoDisponivel;
    }

    public String informacoesUsuario(Sessao sessao, int coluna, char linha) {
        try {
            final int COLUNA = validadorColuna(coluna);
            final int LINHA = validadorLinha(linha);

            if (validarCadeira(sessao, COLUNA, LINHA) == true) {
                return null;
            }
            User[][] cadeiras = sessao.getCadeiras();

            return cadeiras[COLUNA][LINHA].toString();

        } catch (Exception e) {
            return null;
        }
    }

    public void geraMapa(Sessao sessao) {
        final User[][] CADEIRA = sessao.getCadeiras();
        
      
        for(int i = 0; i <= sessao.LINHA - 1; i++){
            if (i == 0){
                System.err.println("X -  1  -  2  -  3  -  4  -  5  -  6  -  7  -  8  -  9  - 10  - 11  - 12  - 13  -  14 ");
            }
            System.err.print(intParaLetra(i +1) + " - ");

            for(int a = 0;a <= sessao.COLUNA - 1; a++){
               if(CADEIRA[a][i] == null){
                    System.err.print("[ ] - ");
               }else{
                    System.err.print("[X] -");
               }
            }
            System.err.println();
        }

    }
    public static char intParaLetra(int numero) {
        if (numero >= 1 && numero <= 26) {
            // Se o número estiver no intervalo de 1 a 26 (correspondente às letras do alfabeto), retorne a letra correspondente.
            return (char) ('A' + numero - 1);
        } else {
            // Caso contrário, retorne um valor padrão ou lance uma exceção, dependendo dos requisitos do seu programa.
            return ' ';
        }
    }
}
