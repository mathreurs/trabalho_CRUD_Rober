package Login;

import java.io.*;
import java.util.ArrayList;

public class Login {
    // Lista de usuários armazenados no sistema
    ArrayList<Dados> dados = new ArrayList<>();

    // Método para adicionar um novo usuário ao sistema
    public void addUsuario(String usuario, String senha, boolean adm,String cpf) {
        load(); // Carrega usuários existentes no sistema
        Dados dad = new Dados(usuario, senha, adm,cpf); // Cria um novo objeto Dados com informações do usuário
        dados.add(dad); // Adiciona o novo usuário à lista
        System.out.println("Cadastrado com sucesso!");
        save(); // Salva os usuários atualizados no arquivo
    }

    // Método para carregar os usuários do arquivo de texto para a lista
    public void load() {
        ArrayList<Dados> dad = new ArrayList<>(); // Lista temporária para armazenar os dados do arquivo

        try (BufferedReader br = new BufferedReader(new FileReader("Txt\\dadosUsuarios.txt"))) {
            String line;
            // Lê cada linha do arquivo e converte em um objeto Dados
            while ((line = br.readLine()) != null) {
                String[] div = line.split(","); // Divide a linha em partes (usuário, senha, tipo de usuário)
                dad.add(new Dados(div[0], div[1], Boolean.parseBoolean(div[2]),div[3]));
            }
            dados = dad; // Atualiza a lista principal com os dados lidos
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e); // Lança exceção em caso de erro de leitura
        }
    }

    // Método para verificar se um usuário existe e se é administrador ou não
    public boolean[] verificarUsuario(String nome, String senha) {
        load(); // Carrega os dados atualizados do arquivo
        boolean[] achado = new boolean[2]; // Array para indicar se o usuário foi encontrado e se é admin

        // Verifica se o usuário existe na lista
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getSenha().equals(senha) && dados.get(i).getUsuario().equalsIgnoreCase(nome)) {
                achado[0] = true; // Marca que o usuário foi encontrado
                achado[1] = dados.get(i).isADM(); // Define se é administrador ou não
            }
        }
        if (!achado[0]) {
            System.out.println("Usuário não encontrado");
        }
        return achado;
    }

    // Método para salvar os usuários da lista no arquivo de texto
    public void save() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Txt\\dadosUsuarios.txt", false));
            // Escreve cada usuário no arquivo, convertendo-o em texto
            for (Dados save : dados) {
                bw.write(save.toString());
                bw.newLine(); // Adiciona uma nova linha após cada usuário
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e); // Lança exceção em caso de erro de escrita
        }
    }

    // Método para mostrar todos os usuários carregados na lista
    public void mostrarUsuarios() {
        load(); // Carrega os dados atualizados do arquivo
        System.out.println("-----------------------------------------------------------------------------------");

        // Imprime informações de cada usuário até o fim da lista
        try {
            int i = 0;
            while (dados.get(i) != null) {
                System.out.println("Usuario: " + dados.get(i).getUsuario() + " | CPF: " + dados.get(i).getCpf()); // Usa o método toText() para exibir informações formatadas
                i++;
            }
        } catch (Exception e) {
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }

    public boolean verificarCpfExistente(String CPF){
        load();
        boolean invalido = false;

        try{
            for(int i = 0; i < dados.size(); i++){
                if(dados.get(i).getCpf().equalsIgnoreCase( CPF)){
                    invalido = true;
                }
            }
        }catch(Exception e){
            System.out.println("CPF invalido");
        }
        return invalido;
    }
}
