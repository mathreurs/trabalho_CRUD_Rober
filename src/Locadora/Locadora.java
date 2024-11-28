package Locadora;

import Dados.Filmes;
import java.io.*;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Scanner;

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
    protected void load() {
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
            while (filmes.size() > i) { // Percorre e exibe os filmes na lista
                System.out.println(filmes.get(i).toText());
                i++;
            }
            System.out.println("-----------------------------------------------------------------------------------");
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }

    private String comparador(String nomeFilme, String palavraProcurada){
        String[] palavras = nomeFilme.split(" ");
        String[] procuras = palavraProcurada.split(" ");

        int correspondencia = 0;

        for(String p1 : palavras){
            for(String p2 : procuras){
                if(p1.equalsIgnoreCase(p2)){
                    correspondencia++;
                }
            }
        }

        if(correspondencia > 0){
            return nomeFilme;
        }else{
            return null;
        }

    }

    // Método para buscar e exibir um filme específico pelo nome ou outros critérios
    public void procurarFilme() {
        load(); // Recarrega a lista de filmes
        Scanner inp = new Scanner(System.in);
        try{
            System.out.println("Qual parametro deseja?\n[1] nome do filme [2] nome do diretor [3] ano de lançamento [4] estudio [5] categoria");
            int opt = inp.nextInt();
            inp.nextLine();

            switch(opt) {
                case 1:
                    System.out.println("Digite o nome do filme que deseja procurar: ");
                    String nomeFilme = inp.nextLine();
                    System.out.println("-----------------------------------------------------------------------------------");
                    for (int i = 0; i < filmes.size(); i++) {
                        if (comparador(filmes.get(i).getNomeFilme(), nomeFilme) != null) {
                            System.out.println(filmes.get(i).toText()); // Exibe o filme se o nome coincidir
                        }
                    }
                    System.out.println("-----------------------------------------------------------------------------------");
                    break;

                case 2:
                    System.out.println("Digite o nome do diretor: ");
                    String nomeDiretor = inp.nextLine();
                    System.out.println("-----------------------------------------------------------------------------------");
                    for (int i = 0; i < filmes.size(); i++) {
                        if (filmes.get(i).getDiretor().equalsIgnoreCase(nomeDiretor)) {
                            System.out.println(filmes.get(i).toText()); // Exibe o filme se o nome coincidir
                        }
                    }
                    System.out.println("-----------------------------------------------------------------------------------");
                    break;

                case 3:
                    System.out.println("Digite o ano de lançamento: ");
                    int anoLancamento = inp.nextInt();
                    System.out.println("-----------------------------------------------------------------------------------");
                    for (int i = 0; i < filmes.size(); i++) {
                        if (filmes.get(i).getAnoLancamento() == anoLancamento) {
                            System.out.println(filmes.get(i).toText()); // Exibe o filme se o ano coincidir
                        }
                    }
                    System.out.println("-----------------------------------------------------------------------------------");
                    break;

                case 4:
                    System.out.println("Digite o estudio que deseja: ");
                    String nomeEstudio = inp.nextLine();
                    System.out.println("-----------------------------------------------------------------------------------");
                    for (int i = 0; i < filmes.size(); i++) {
                        if (filmes.get(i).getEstudio().equalsIgnoreCase(nomeEstudio)) {
                            System.out.println(filmes.get(i).toText()); // Exibe o filme se o estúdio coincidir
                        }
                    }
                    System.out.println("-----------------------------------------------------------------------------------");
                    break;

                case 5:
                    System.out.println("Digite o estudio que deseja: ");
                    String categoria = inp.nextLine();
                    System.out.println("-----------------------------------------------------------------------------------");
                    for (int i = 0; i < filmes.size(); i++) {
                        if (filmes.get(i).getCategoria().equalsIgnoreCase(categoria)) {
                            System.out.println(filmes.get(i).toText()); // Exibe o filme se o a categoria coincidir
                        }
                    }
                    System.out.println("-----------------------------------------------------------------------------------");
                    break;
                }
        }catch(Exception ex){
            System.out.println("Comando invalido!");
            }
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
