package UI;

import java.security.Provider.Service;
import java.util.Scanner;

import model.Sessao;
import model.User;
import service.ServiceSessao;

public class TelaInicial {
    public static void show() {
        try {
            Scanner sc = new Scanner(System.in);
            boolean sair = false;
            ServiceSessao serviceSessao = new ServiceSessao();
            int coluna;
            String linha;
            String idade;
            String cpf;
            String nome;
            long id;
            Sessao sessao = new Sessao();

            System.out.println("Bem vindo Tela Inicial");

            do {
                System.out.println("1- Reservar");
                System.out.println("2- cancelar");
                System.out.println("3- alterar");
                System.out.println("4- mapa");
                System.out.println("5- cadeiras disponiveis");
                System.out.println("6- cadeiras nao disponiveis");
                System.out.println("7- sair");

                int value = sc.nextInt();

                switch (value) {
                    case 1:
                        System.out.println("digite a coluna : ");
                        coluna = sc.nextInt();

                        System.out.println("digite a linha : ");
                        linha = sc.next();

                        System.out.println("Digite os dados:");

                        System.out.print("ID: ");
                        id = sc.nextLong();
                        sc.nextLine(); // Limpa o buffer

                        System.out.print("Nome: ");
                        nome = sc.nextLine();

                        System.out.print("CPF: ");
                        cpf = sc.nextLine();

                        System.out.print("Idade: ");
                        idade = sc.nextLine();

                        serviceSessao.reservar(coluna, linha.charAt(0), new User(id, nome, cpf, idade), sessao);
                        break;

                    case 2:
                        System.out.println("digite a coluna : ");
                        coluna = sc.nextInt();

                        System.out.println("digite a linha : ");
                        linha = sc.next();

                        serviceSessao.cancelar(coluna, linha.charAt(0), sessao);

                    case 3:
                        System.out.println("digite a coluna : ");
                        coluna = sc.nextInt();

                        System.out.println("digite a linha : ");
                        linha = sc.next();

                        System.out.println("Digite os dados:");

                        System.out.print("ID: ");
                        id = sc.nextLong();
                        sc.nextLine(); // Limpa o buffer

                        System.out.print("Nome: ");
                        nome = sc.nextLine();

                        System.out.print("CPF: ");
                        cpf = sc.nextLine();

                        System.out.print("Idade: ");

                        idade = sc.nextLine();

                        serviceSessao.alterar(coluna, linha.charAt(0), new User(id, nome, cpf, idade), sessao);

                    case 4:
                            
                    case 5:
                        System.err.println(serviceSessao.cadeirasDisponivel(sessao));
                        
                    case 6:
                        System.err.println(serviceSessao.cadeirasNaoDisponivel(sessao)); 

                    default:
                        break;
                }

            } while (sair = true);

        } catch (Exception e) {
            System.err.println(e.toString());
        }

    }
}
