package Login;

public class Dados {
    // Atributos privados para armazenar as informações do usuário
    private String usuario; // Nome de usuário
    private String senha; // Senha do usuário
    private String cpf; // CPF do usuário
    private boolean ADM; // Indica se o usuário é administrador (ADM)

    // Construtor da classe que inicializa os atributos com valores recebidos
    public Dados(String usuario, String senha, boolean adm, String cpf) {
        this.usuario = usuario;
        this.senha = senha;
        this.ADM = adm;
        this.cpf = cpf;
    }

    // Representa os dados do usuário como uma linha de texto formatada, para salvar no arquivo
    @Override
    public String toString() {
        return this.usuario + "," + this.senha + "," + this.ADM + "," + this.cpf;
    }

    // Métodos getters para acessar os valores dos atributos privados

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

    // Retorna se o usuário é administrador (ADM)
    public boolean isADM() {
        return ADM;
    }
}
