package Login;

public class Dados {
    // Atributos privados da classe
    private String usuario; // Nome de usuário
    private String senha; // Senha do usuário
    private String cpf; // CPF do usuário
    private boolean ADM; // Indica se o usuário é administrador (ADM)

    // Construtor da classe que recebe o nome de usuário, senha, status de ADM e CPF
    public Dados(String usuario, String senha, boolean adm, String cpf) {
        this.usuario = usuario;
        this.senha = senha;
        this.ADM = adm;
        this.cpf = cpf;
    }

    // Método para representar os dados do usuário como uma única linha de texto
    // utilizado para armazenar os dados no arquivo de texto
    @Override
    public String toString() {
        return this.usuario + "," + this.senha + "," + this.ADM + "," + this.cpf;
    }

    // Métodos getters e setters para acessar e modificar os atributos privados

    // Retorna o CPF do usuário
    public String getCpf() {
        return cpf;
    }

    // Retorna o nome de usuário
    public String getUsuario() {
        return usuario;
    }

    // Retorna a senha do usuário
    public String getSenha() {
        return senha;
    }

    // Verifica se o usuário é administrador (ADM)
    public boolean isADM() {
        return ADM;
    }

}
