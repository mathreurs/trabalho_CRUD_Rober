package Locadora;

import Dados.Filmes;
import Login.Login;

import java.util.Scanner;

public class Adm extends Locadora {
    // Declara um objeto da classe Filmes para representar o filme a ser adicionado ou removido
    Filmes fil;

    // Metodo para adicionar um novo filme ao catálogo
    public void addFilme(String categoria, int anoLancamento, String estudio, String diretor, String nomeFilme,boolean alugado) {
        // Cria um novo objeto Filmes com os detalhes fornecidos
        load();

        int maior = 0;
        if(!filmes.isEmpty()) {
            int cont = 0;
            while (cont < filmes.size()) {
                if (maior < filmes.get(cont).getCodigo()) {
                    maior = filmes.get(cont).getCodigo();
                }
                cont++;
            }
        }
        fil = new Filmes(categoria, anoLancamento, estudio, diretor, nomeFilme, maior + 1, alugado);
        filmes.add(fil);
        save();
    }

    // Método para remover um filme do catálogo pelo nome
    public void removerFilme(String nome) {
        load();
        // Percorre a lista de filmes para encontrar o filme com o nome especificado
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getNomeFilme().equals(nome)) {
                filmes.remove(i); // Remove o filme da lista
            }
        }
        save(); // Salva a lista atualizada no arquivo ou base de dados
        mostrarFilmes(); // Exibe a lista de filmes após a remoção
    }

    // Método para alterar atributos de um filme existente
    public void alterarFilme(){
        load(); // Carrega a lista de filmes
        Scanner inp = new Scanner(System.in);

        System.out.println("Digite o nome do filme que deseja alterar: ");
        String nome = inp.nextLine();

        System.out.println("O que deseja alterar no filme?\n[1] nome do filme [2] diretor [3] ano de lançamento [4] código [5] estúdio");
        int opt = inp.nextInt();
        int i = 0;

        // Procura o filme pelo nome
        while(i < filmes.size() && !filmes.get(i).getNomeFilme().equalsIgnoreCase(nome)){
            i++;
        }

        inp.nextLine(); // Limpa o buffer

        if(i < filmes.size()) { // Verifica se o filme foi encontrado
            switch (opt) {
                case 1:
                    System.out.println("Digite o novo nome do filme: ");
                    filmes.get(i).setNomeFilme(inp.nextLine());
                    break;
                case 2:
                    System.out.println("Digite o novo nome do diretor: ");
                    filmes.get(i).setDiretor(inp.nextLine());
                    break;
                case 3:
                    System.out.println("Digite o novo ano de lançamento: ");
                    filmes.get(i).setAnoLancamento(inp.nextInt());
                    break;
                case 4:
                    try {
                        System.out.println("Digite o novo código do filme: ");
                        filmes.get(i).setCodigo(inp.nextInt());
                    } catch(Exception e) {
                        System.out.println("Código inválido");
                    }
                    break;
                case 5:
                    System.out.println("Digite o novo nome do estúdio: ");
                    filmes.get(i).setEstudio(inp.nextLine());
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } else {
            System.out.println("O filme requisitado não existe no sistema");
        }
        save(); // Salva as alterações no arquivo
    }

    // Método para remover um usuário pelo nome de usuário
    public void removerUsuario(String cpfAtual){
        load();
        Login log = new Login();
        log.removerUsuario(cpfAtual); // Chama o método para remover o usuário
    }
}
