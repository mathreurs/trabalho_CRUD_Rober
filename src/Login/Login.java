package Login;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Login {
    // Lista para armazenar objetos da classe Dados, representando usuários do sistema
    ArrayList<Dados> dados = new ArrayList<>();

    // Método para adicionar um novo usuário ao sistema
    public void addUsuario(String usuario, String senha, boolean adm, String cpf) {
        load(); // Carrega os usuários existentes do arquivo para a lista
        Dados dad = new Dados(usuario, senha, adm, cpf); // Cria um novo objeto Dados com as informações do usuário
        dados.add(dad); // Adiciona o novo usuário à lista de dados
        System.out.println("Cadastrado com sucesso!");
        save(); // Salva os usuários atualizados no arquivo de texto
    }

    // Método para carregar os usuários do arquivo de texto e adicioná-los na lista
    public void load() {
        ArrayList<Dados> dad = new ArrayList<>(); // Lista temporária para armazenar os dados carregados do arquivo

        try (BufferedReader br = new BufferedReader(new FileReader("Txt\\dadosUsuarios.txt"))) {
            String line;
            // Lê cada linha do arquivo e converte para um objeto Dados
            while ((line = br.readLine()) != null) {
                String[] div = line.split(","); // Divide a linha em partes (usuário, senha, tipo de usuário e CPF)
                dad.add(new Dados(div[0], div[1], Boolean.parseBoolean(div[2]), div[3])); // Adiciona cada usuário lido na lista temporária
            }
            dados = dad; // Atualiza a lista principal com os dados carregados
        } catch (IOException e) {
            throw new RuntimeException(e); // Lança exceção em caso de erro de leitura
        }
    }

    // Método para verificar se um usuário existe e se é administrador
    public boolean[] verificarUsuario(String nome, String senha) {
        load(); // Carrega os dados atualizados do arquivo
        boolean[] achado = new boolean[2]; // Array para indicar se o usuário foi encontrado e se é administrador

        // Verifica se o usuário existe na lista e se as credenciais estão corretas
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getSenha().equals(senha) && dados.get(i).getUsuario().equalsIgnoreCase(nome)) {
                achado[0] = true; // Marca que o usuário foi encontrado
                achado[1] = dados.get(i).isADM(); // Define se é administrador
            }
        }
        if (!achado[0]) {
            System.out.println("Usuário não encontrado");
        }
        return achado;
    }

    // Método para salvar a lista de usuários no arquivo de texto
    public void save() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Txt\\dadosUsuarios.txt", false));
            // Escreve cada usuário no arquivo, convertendo-o em uma linha de texto
            for (Dados save : dados) {
                bw.write(save.toString());
                bw.newLine(); // Adiciona uma nova linha para cada usuário
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e); // Lança exceção em caso de erro de escrita
        }
    }

    // Método para exibir todos os usuários carregados na lista
    public void mostrarUsuarios() {
        load(); // Carrega os dados atualizados do arquivo
        System.out.println("-----------------------------------------------------------------------------------");

        // Itera sobre a lista e imprime as informações de cada usuário
        try {
            int i = 0;
            while (dados.get(i) != null) {
                System.out.println("Usuario: " + dados.get(i).getUsuario() + " | CPF: " + dados.get(i).getCpf()); // Exibe o nome e CPF de cada usuário
                i++;
            }
        } catch (Exception e) {
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }

    // Método para verificar se um CPF já existe no sistema
    public boolean verificarCpfExistente(String CPF) {
        load();
        boolean invalido = false;

        // Verifica se algum usuário já possui o CPF fornecido
        try {
            for (int i = 0; i < dados.size(); i++) {
                if (dados.get(i).getCpf().equalsIgnoreCase(CPF)) {
                    invalido = true; // Marca como inválido se o CPF já estiver cadastrado
                }
            }
        } catch (Exception e) {
            System.out.println("CPF invalido");
        }
        return invalido;
    }

    // Método para remover um usuário do sistema, verificando o nome e CPF
    public void removerUsuario(String usuarioAtual) {
        load(); // Carrega a lista de usuários do arquivo
        Scanner inp = new Scanner(System.in);

        try {
            System.out.println("Qual o nome e CPF do usuário que deseja remover");
            System.out.println("Nome: ");
            String nome = inp.nextLine();

            // Verifica se o usuário atual não é o mesmo que deseja ser removido
            if (!nome.equalsIgnoreCase(usuarioAtual)) {

                System.out.println("CPF: ");
                String cpf = inp.next();

                int i = 0;

                // Procura pelo usuário na lista verificando nome e CPF
                while (i < dados.size() && (!dados.get(i).getUsuario().equalsIgnoreCase(nome) && !dados.get(i).getCpf().equalsIgnoreCase(cpf))) {
                    i++;
                }

                // Verifica se o usuário foi encontrado e, se sim, o remove
                if (!dados.isEmpty() && i == dados.size()) {
                    System.out.println("O usuário não existe no sistema");
                } else {
                    dados.remove(i); // Remove o usuário da lista
                    System.out.println("Usuário removido com sucesso!");
                    save(); // Salva as mudanças no arquivo
                }
            } else {
                System.out.println("O usuário requerido está sendo utilizado no momento");
            }

        } catch (Exception e) {
            // Tratamento de exceção sem mensagem específica
        }
    }
}
