// Importa o pacote de login (assume que existe uma classe Login no pacote Login)
import Login.Login;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    // Cria um scanner para ler entradas do usuário no console
    static Scanner inp = new Scanner(System.in);

    public static void main(String[] args){
        // Instancia o sistema (assume que existe uma classe Sistema)
        Sistema sistema = new Sistema();

        // Controla o loop principal do programa
        boolean ligado = true;

        // Loop principal do programa
        while(ligado) {
            int opt = 0;
            // Exibe o menu principal para o usuário
            System.out.println("Bem vindo ao sistema!\nJá possui cadastro? [1] Sim [2] Não [3] Verificar usuários cadastrados [5] Sair do sistema");

            // Loop para garantir que o usuário insira uma opção válida
            while(opt == 0){
                try{
                    // Lê a opção do usuário
                    opt = inp.nextInt();
                } catch (Exception e) {
                    // Em caso de erro, informa o usuário e solicita novamente
                    System.out.println("Não entendi o comando que foi dado\nJá possui cadastro? [1] Sim [2] Não [3] Verificar usuários cadastrados 3[5] Sair do sistema");
                    opt = 0;
                }
                // Limpa o buffer do scanner
                inp.nextLine();
            }

            // Cria uma instância da classe Login para verificar e manipular usuários
            Login log = new Login();

            // Verifica a opção escolhida pelo usuário
            switch (opt) {
                case 1:
                    // Caso o usuário já possua cadastro
                    System.out.println("Digite seu nome de usuário: ");
                    String usuario = inp.nextLine();
                    System.out.println("Digite sua senha: ");
                    String senha = inp.nextLine();

                    // Verifica o nome de usuário e senha com o método verificarUsuario
                    boolean[] verificar = log.verificarUsuario(usuario, senha);

                    if (verificar[0] && verificar[1]) {
                        // Se usuário é administrador, chama o sistema administrativo
                        sistema.sistemAdm();
                    } else if (verificar[0] && !verificar[1]) {
                        // Se é um usuário normal, chama o sistema de usuário
                        sistema.sistemUsuario();
                    }
                    break;

                case 2:
                    // Caso o usuário não possua cadastro, realiza o processo de cadastro
                    System.out.println("Digite seu nome de usuário: ");
                    String usuarioCad = inp.nextLine();
                    System.out.println("Digite sua senha: ");
                    String senhaCad = inp.nextLine();
                    System.out.println("O usuario é ADM? [1] Sim [2] Não");
                    int adm = inp.nextInt();

                    System.out.println("Digite o numero do CPF:");
                    String cpf = inp.next();

                    while(!validarCpf(cpf)){
                        cpf = inp.next();
                    }

                    // Adiciona o novo usuário, verificando se é um administrador ou não
                    if (adm == 1) {
                        log.addUsuario(usuarioCad, senhaCad, true,cpf);
                    } else if (adm == 2) {
                        log.addUsuario(usuarioCad, senhaCad, false,cpf);
                    }
                    break;
                case 3:
                    log.mostrarUsuarios();
                    break;

                case 5:
                    // Finaliza o programa caso o usuário escolha sair
                    System.out.println("Saiu do sistema");
                    ligado = false;
                    break;

                default:
                    // Informa o usuário caso uma opção inválida seja escolhida
                    System.out.println("Comando inválido!");
                    break;
            }
        }


    }

    // valdiar o CPF digitado
    public static boolean validarCpf(String cpf) {
        Login log = new Login();

        if(!log.verificarCpfExistente(cpf)){
            boolean valido = false;
            int verificar = 0;

            int[] lista = new int[11];
            // testar o primeiro digito validador
            try {
                for (int i = 0; i < 11; i++) {
                    lista[i] = Character.getNumericValue(cpf.charAt(i));
                }

                int validar = 0;

                for (int i = 0; i < 9; i++) {
                    validar += lista[i] * (10 - i);
                }

                int valid = 11 - (validar % 11);


                if (valid == lista[9]) {
                    verificar++;
                }

            } catch (Exception e) {
                System.out.println("Digito 1 invalido");
            }

            // testar o segundo digito validador
            try {
                for (int i = 0; i < 11; i++) {
                    lista[i] = Character.getNumericValue(cpf.charAt(i));
                }

                int validar = 0;

                for (int i = 0; i < 10; i++) {
                    validar += lista[i] * (11 - i);
                }

                int valid = 11 - (validar % 11);

                if (valid == lista[10]) {
                    verificar++;
                }

            } catch (Exception e) {
                System.out.println("Digito 2 invalido");
            }

            if (verificar == 2) {
                valido = true;
            } else {
                System.out.println("CPF invalido, tente novamente: ");
            }

            return valido;
        }else{
            System.out.println("CPF já cadastrado, tente novamente");
            return false;
        }
    }
}
