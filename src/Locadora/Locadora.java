package Locadora;

import Dados.Filmes;
import java.io.*;
import java.util.ArrayList;

public class Locadora {
    // Lista que armazena os filmes disponíveis na locadora
    ArrayList<Filmes> filmes = new ArrayList<>();

    // Método para salvar a lista de filmes no arquivo de texto
    protected void save() {
        try {
            // Cria um BufferedWriter para escrever no arquivo "saves.txt"
            BufferedWriter bw = new BufferedWriter(new FileWriter("Txt\\saves.txt", false));
            for (Filmes save : filmes) {
                bw.write(save.toString()); // Escreve cada filme no formato string
                bw.newLine();
            }
            bw.close(); // Fecha o BufferedWriter
        } catch (IOException e) {
            throw new RuntimeException(e); // Lança exceção caso ocorra um erro de E/S
        }
        load(); // Recarrega a lista após salvar
    }

    // Método para carregar os filmes do arquivo de texto para a lista
    private void load() {
        ArrayList<Filmes> fil = new ArrayList<>(); // Lista temporária para armazenar os filmes carregados

        try (BufferedReader br = new BufferedReader(new FileReader("Txt\\saves.txt"))) {
            String line;
            // Lê cada linha do arquivo e transforma em um objeto Filmes
            while ((line = br.readLine()) != null) {
                String[] div = line.split(",");
                fil.add(new Filmes(div[0], Integer.parseInt(div[1]), div[2], div[3], div[4], Integer.parseInt(div[5]), Boolean.parseBoolean(div[6])));
            }
            filmes = fil; // Atualiza a lista principal com os filmes carregados
        } catch (IOException e) {
            throw new RuntimeException(e); // Lança exceção caso ocorra um erro de E/S
        }
    }

    // Método para exibir todos os filmes disponíveis no catálogo
    public void mostrarFilmes() {
        load(); // Recarrega a lista de filmes
        System.out.println("-----------------------------------------------------------------------------------");
        try {
            int i = 0;
            while (filmes.get(i) != null) { // Percorre e exibe os filmes na lista
                System.out.println(filmes.get(i).toText());
                i++;
            }
        } catch (Exception e) {
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }

    // Método para buscar e exibir um filme específico pelo nome
    public void procurarFilme(String nome) {
        load(); // Recarrega a lista de filmes
        System.out.println("-----------------------------------------------------------------------------------");
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getNomeFilme().equalsIgnoreCase(nome)) {
                System.out.println(filmes.get(i).toText()); // Exibe o filme se o nome coincidir
            }
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }

    // Método para alugar um filme
    public void alugarFilme(String nome) {
        load(); // Recarrega a lista de filmes
        int i = 0;
        try {
            while (!(filmes.get(i).getNomeFilme()).equalsIgnoreCase(nome)) {
                i++;
            }
            // Verifica se o filme encontrado está disponível para aluguel
            if (filmes.get(i).getNomeFilme().equalsIgnoreCase(nome) && !filmes.get(i).isAlugado()) {
                filmes.get(i).setAlugado(true); // Marca o filme como alugado
                System.out.println("O filme " + nome + " foi alugado com sucesso!");
            } else {
                System.out.println("O filme " + nome + " já foi alugado!");
            }
            save(); // Salva o estado atualizado no arquivo
        } catch (Exception e) {
            System.out.println("O filme desejado não existe no sistema");
        }
    }

    // Método para devolver um filme
    public void devolverFilme(String nome) {
        load(); // Recarrega a lista de filmes
        int i = 0;
        try {
            while (!(filmes.get(i).getNomeFilme()).equalsIgnoreCase(nome)) {
                i++;
            }
            // Verifica se o filme está marcado como alugado
            if (filmes.get(i).getNomeFilme().equalsIgnoreCase(nome) && filmes.get(i).isAlugado()) {
                filmes.get(i).setAlugado(false); // Marca o filme como devolvido
                System.out.println("O filme " + nome + " foi devolvido com sucesso!");
            } else {
                System.out.println("O filme " + nome + " não foi alugado!");
            }
            save(); // Salva o estado atualizado no arquivo
        } catch (Exception e) {
            System.out.println("O filme desejado não existe no sistema");
        }
    }
}
