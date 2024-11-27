// Importa as classes Adm e Locadora do pacote Locadora
import Locadora.Adm;
import Locadora.Locadora;

import java.util.*;

public class Sistema {
    public String usuarioAtual; // Armazena o nome do usuário atualmente logado no sistema

    // Método para o sistema administrativo
    public void sistemAdm(){
        // Cria uma instância da classe Adm para gerenciar filmes
        Adm adm = new Adm();
        System.out.println("Bem vindo ao sistema!");
        boolean ligado = true; // Variável de controle para o loop do sistema

        // Loop principal do sistema administrativo
        while(ligado){
            // Scanner para ler entrada do usuário
            Scanner inp = new Scanner(System.in);

            // Exibe o menu de opções para o administrador
            System.out.println("[1] Adicionar novo filme \n[2] Remover um filme\n[3] Alugar um filme\n[4] Devolver um filme\n[5] Ver os filmes no catálogo\n[6] Procurar um filme\n[7] alterar dados de um filme\n[8] remover um usuário \n[10] Deslogar do sistema");
            int opt = inp.nextInt(); // Lê a opção escolhida pelo administrador
            inp.nextLine(); // Limpa o buffer do scanner

            // Processa a escolha do administrador
            switch(opt){
                case 1:
                    // Adicionar novo filme ao sistema
                    System.out.println("Nome do filme: ");
                    String nomeAdd = inp.nextLine();
                    System.out.println("Categoria: ");
                    String categoria = inp.nextLine();
                    System.out.println("Estúdio: ");
                    String estudio = inp.nextLine();
                    System.out.println("Nome do diretor: ");
                    String diretor = inp.nextLine();
                    System.out.println("Número do código:");
                    int codigo = inp.nextInt();
                    System.out.println("Ano de lançamento: ");
                    int anoLancamento = inp.nextInt();

                    // Chama o método para adicionar o filme ao catálogo da classe Adm
                    adm.addFilme(categoria, anoLancamento, estudio, diretor, nomeAdd, codigo, false);
                    break;

                case 2:
                    // Remover filme do sistema
                    System.out.println("Digite o nome do filme que deseja remover: ");
                    String nomeRemove = inp.nextLine();
                    adm.removerFilme(nomeRemove); // Chama o método de remoção de filme
                    break;

                case 3:
                    // Alugar um filme do sistema
                    System.out.println("Digite o nome do filme que deseja alugar: ");
                    String nomeAlugar = inp.nextLine();
                    adm.alugarFilme(nomeAlugar); // Chama o método de aluguel de filme
                    break;

                case 4:
                    // Devolver um filme alugado
                    System.out.println("Digite o nome do filme que deseja devolver: ");
                    String nomeDevolv = inp.nextLine();
                    adm.devolverFilme(nomeDevolv); // Chama o método de devolução de filme
                    break;

                case 5:
                    // Mostrar todos os filmes disponíveis no catálogo
                    adm.mostrarFilmes(); // Chama o método para exibir filmes
                    break;

                case 6:
                    // Procurar filme específico no catálogo
                    adm.procurarFilme(); // Chama o método de busca de filme
                    break;

                case 7:
                    // Alterar dados de um filme
                    adm.alterarFilme(); // Chama o método para alterar informações de um filme
                    break;

                case 8:
                    // Remover um usuário do sistema
                    adm.removerUsuario(usuarioAtual); // Remove o usuário atual do sistema
                    break;

                case 10:
                    // Deslogar do sistema administrativo
                    ligado = false; // Interrompe o loop do sistema administrativo
                    System.out.println("Deslogado do sistema!");
                    break;
            }
        }
    }

    // Método para o sistema de usuário
    public void sistemUsuario(){
        // Instancia a classe Locadora para gerenciar ações de usuário comum
        Locadora loc = new Locadora();
        boolean ligado = true; // Variável de controle para o loop do sistema de usuário
        System.out.println("Bem vindo ao sistema!");

        // Loop principal do sistema de usuário
        while(ligado){
            // Scanner para ler entrada do usuário
            Scanner inp = new Scanner(System.in);

            // Exibe o menu de opções para o usuário
            System.out.println("[1] Alugar um filme \n[2] Devolver um filme \n[3] Ver os filmes no catálogo\n[4] Procurar um filme específico\n[5] Deslogar do sistema");
            int opt = inp.nextInt(); // Lê a opção escolhida pelo usuário
            inp.nextLine(); // Limpa o buffer do scanner

            // Processa a escolha do usuário
            switch(opt){
                case 1:
                    // Alugar um filme
                    System.out.println("Digite o nome do filme que deseja alugar: ");
                    String nomeAlug = inp.nextLine();
                    loc.alugarFilme(nomeAlug); // Chama o método de aluguel de filme
                    break;

                case 2:
                    // Devolver um filme alugado
                    System.out.println("Digite o nome do filme que deseja devolver: ");
                    String nomeDevolv = inp.nextLine();
                    loc.devolverFilme(nomeDevolv); // Chama o método de devolução de filme
                    break;

                case 3:
                    // Mostrar todos os filmes disponíveis no catálogo
                    loc.mostrarFilmes(); // Exibe a lista de filmes disponíveis
                    break;

                case 4:
                    // Procurar um filme específico
                    loc.procurarFilme(); // Chama o método de busca de filme
                    break;

                case 5:
                    // Deslogar do sistema de usuário
                    System.out.println("Deslogado do sistema!");
                    ligado = false; // Interrompe o loop do sistema de usuário
                    break;
            }
        }
    }
}
