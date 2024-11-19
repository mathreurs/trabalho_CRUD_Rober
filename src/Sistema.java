// Importa as classes Adm e Locadora do pacote Locadora
import Locadora.Adm;
import Locadora.Locadora;

import java.util.*;
public class Sistema {

    // Método para o sistema administrativo
    public void sistemAdm(){
        // Cria uma instância da classe Adm para gerenciar filmes
        Adm adm = new Adm();
        System.out.println("Bem vindo ao sistema!");
        boolean ligado = true;

        // Loop principal do sistema administrativo
        while(ligado){
            // Scanner para ler entrada do usuário
            Scanner inp = new Scanner(System.in);

            // Exibe o menu de opções para o administrador
            System.out.println("[1] Adicionar novo filme \n[2] Remover um filme\n[3] Alugar um filme\n[4] Devolver um filme\n[5] Ver os filmes no catálogo\n[6] Procurar um filme\n[7] Deslogar do sistema");
            int opt = inp.nextInt();
            inp.nextLine(); // Limpa o buffer do scanner

            // Processa a escolha do administrador
            switch(opt){
                case 1:
                    // Adicionar novo filme
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

                    // Chama o método para adicionar o filme ao catálogo
                    adm.addFilme(categoria, anoLancamento, estudio, diretor, nomeAdd, codigo, false);
                    break;

                case 2:
                    // Remover filme
                    System.out.println("Digite o nome do filme que deseja remover: ");
                    String nomeRemove = inp.nextLine();
                    adm.removerFilme(nomeRemove);
                    break;

                case 3:
                    // Alugar filme
                    System.out.println("Digite o nome do filme que deseja alugar: ");
                    String nomeAlugar = inp.nextLine();
                    adm.alugarFilme(nomeAlugar);
                    break;

                case 4:
                    // Devolver filme
                    System.out.println("Digite o nome do filme que deseja devolver: ");
                    String nomeDevolv = inp.nextLine();
                    adm.devolverFilme(nomeDevolv);
                    break;

                case 5:
                    // Mostrar todos os filmes no catálogo
                    adm.mostrarFilmes();
                    break;

                case 6:
                    // Procurar filme específico
                    System.out.println("Digite o nome do filme que deseja procurar: ");
                    String nomeProc = inp.nextLine();
                    adm.procurarFilme(nomeProc);
                    break;

                case 7:
                    // Deslogar do sistema
                    ligado = false;
                    System.out.println("Deslogado do sistema!");
                    break;
            }
        }
    }

    // Método para o sistema de usuário
    public void sistemUsuario(){
        // Instancia a classe Locadora para gerenciar ações de usuário comum
        Locadora loc = new Locadora();
        boolean ligado = true;
        System.out.println("Bem vindo ao sistema!");

        // Loop principal do sistema de usuário
        while(ligado){
            // Scanner para ler entrada do usuário
            Scanner inp = new Scanner(System.in);

            // Exibe o menu de opções para o usuário
            System.out.println("[1] Alugar um filme \n[2] Devolver um filme \n[3] Ver os filmes no catálogo\n[4] Procurar um filme específico\n[5] Deslogar do sistema");
            int opt = inp.nextInt();
            inp.nextLine(); // Limpa o buffer do scanner

            // Processa a escolha do usuário
            switch(opt){
                case 1:
                    // Alugar filme
                    System.out.println("Digite o nome do filme que deseja alugar: ");
                    String nomeAlug = inp.nextLine();
                    loc.alugarFilme(nomeAlug);
                    break;

                case 2:
                    // Devolver filme
                    System.out.println("Digite o nome do filme que deseja devolver: ");
                    String nomeDevolv = inp.nextLine();
                    loc.devolverFilme(nomeDevolv);
                    break;

                case 3:
                    // Mostrar todos os filmes no catálogo
                    loc.mostrarFilmes();
                    break;

                case 4:
                    // Procurar filme específico
                    System.out.println("Digite o nome do filme que deseja procurar:");
                    String nomeProc  = inp.nextLine();
                    loc.procurarFilme(nomeProc);
                    break;

                case 5:
                    // Deslogar do sistema
                    System.out.println("Deslogado do sistema!");
                    ligado = false;
                    break;
            }
        }
    }
}
