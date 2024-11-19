package Locadora;

import Dados.Filmes;

public class Adm extends Locadora {
    // Declara um objeto da classe Filmes para representar o filme a ser adicionado ou removido
    Filmes fil;

    // Método para adicionar um novo filme ao catálogo
    public void addFilme(String categoria, int anoLancamento, String estudio, String diretor, String nomeFilme, int codigo, boolean alugado) {
        // Cria um novo objeto Filmes com os detalhes fornecidos
        fil = new Filmes(categoria, anoLancamento, estudio, diretor, nomeFilme, codigo, alugado);
        filmes.add(fil); // Adiciona o filme à lista de filmes
        save(); // Salva a lista atualizada no arquivo ou base de dados
    }

    // Método para remover um filme do catálogo pelo nome
    public void removerFilme(String nome) {
        // Percorre a lista de filmes para encontrar o filme com o nome especificado
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getNomeFilme().equals(nome)) {
                filmes.remove(i); // Remove o filme da lista
            }
        }
        save(); // Salva a lista atualizada no arquivo ou base de dados
        mostrarFilmes(); // Exibe a lista de filmes após a remoção
    }
}
