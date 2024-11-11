import Locadora.Locadora;

import java.util.Scanner;

public class Main {
    static Locadora loc =  new Locadora();
    static Scanner inp = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        loc.load();


        addFilme();

        loc.save();
        loc.mostrar();
    }

    public static void addFilme(){

        System.out.println("diretor");
        String nomeD = inp.nextLine();
        System.out.println("filme");
        String nomeF = inp.nextLine();
        System.out.println("estudio");
        String nomeS = inp.nextLine();
        System.out.println("categoria");
        char cat = Character.toUpperCase(inp.next().charAt(0));
        System.out.println("ano");
        int ano = inp.nextInt();
        System.out.println("codigo");
        int codigo = inp.nextInt();

        loc.addFilmes(cat,ano,nomeS,nomeD, nomeF, codigo);
    }

}
