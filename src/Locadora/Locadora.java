package Locadora;

import java.io.*;
import java.util.ArrayList;

public class Locadora {
    ArrayList<Filmes> filmes = new ArrayList<>();
    Filmes fil;

    public void addFilmes(char categoria, int anoLancamento, String estudio, String diretor, String nomeFilme, int codigo){
        fil = new Filmes(categoria, anoLancamento, estudio, diretor, nomeFilme, codigo);
        filmes.add(fil);
        save();
    }

    public void save() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("saves.txt",false));
            for(Filmes save : filmes){
                bw.write(save.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load(){
        ArrayList<Filmes> fil = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("saves.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String[] div = line.split(",");

                fil.add(new Filmes(div[0].charAt(0),Integer.parseInt(div[1]),div[2],div[3],div[4],Integer.parseInt(div[5])));
            }
            filmes = fil;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removerFilme(String nome){
        int i = 0;
        while(!filmes.get(i).getNomeFilme().equals(nome)){

        }
    }

    public void mostrar(){
        System.out.println("-----------------------------------------------------------------------------------");
        try{
            int i = 0;
            while(filmes.get(i) != null){
                System.out.println(filmes.get(i).toText());
                i++;
            }
        }catch(Exception e){
            System.out.println("-----------------------------------------------------------------------------------");
        }

    }
}
