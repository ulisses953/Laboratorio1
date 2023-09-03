package UI;

import javax.swing.JFrame;

public class TelaInicial extends JFrame {
    public static final int LARGURA = 800;
    public static final int ALTURA = 600;

    public TelaInicial() {
        FrameConfiguration();
    }
    /**
     * Configura o frame com as configuracoes padroes
     */
    private void FrameConfiguration(){
        this.setVisible(true); //deixa visivel ao usuario
        this.setSize(LARGURA, ALTURA);//define a altura e a largura da tela inicial
        this.setResizable(false);
        this.setLocationRelativeTo(null);// aparece no meio da aplicacao
        this.setTitle("Projeto Laboratorio 1");// titulo do projeto
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// finalizacao do programa apos o termino
    }
}
