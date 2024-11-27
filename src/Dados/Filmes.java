package Dados;

public class Filmes {
    // Atributos do filme
    private int codigo;           // Código único do filme
    private String nomeFilme;      // Nome do filme
    private String diretor;        // Nome do diretor
    private String estudio;        // Estúdio de produção
    private int anoLancamento;     // Ano de lançamento
    private String categoria;      // Categoria ou gênero do filme
    private boolean alugado;       // Status de aluguel do filme (true se alugado)

    // Construtor da classe que inicializa todos os atributos do filme
    public Filmes(String categoria, int anoLancamento, String estudio, String diretor, String nomeFilme, int codigo, boolean alugado) {
        this.categoria = categoria;
        this.anoLancamento = anoLancamento;
        this.estudio = estudio;
        this.diretor = diretor;
        this.nomeFilme = nomeFilme;
        this.codigo = codigo;
        this.alugado = alugado;
    }

    // Método que retorna uma representação do objeto em formato de texto (para salvar no arquivo)
    @Override
    public String toString() {
        return categoria + "," + anoLancamento + "," + estudio + "," + diretor + "," + nomeFilme + "," + codigo + "," + alugado;
    }

    // Método que retorna uma representação amigável do objeto, formatada para exibição
    public String toText() {
        return "[categoria: " + categoria + " | ano de lançamento: " + anoLancamento + " | estudio: " + estudio + " | diretor: " + diretor + " | nome do filme: " + nomeFilme + " | codigo: " + codigo + " | alugado: " + alugado + "]";
    }

    // Getters e setters para acessar e modificar os atributos do filme

    // Retorna a categoria do filme
    public String getCategoria() {
        return categoria;
    }

    // Define a categoria do filme
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Retorna o ano de lançamento do filme
    public int getAnoLancamento() {
        return anoLancamento;
    }

    // Define o ano de lançamento do filme
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    // Retorna o estúdio do filme
    public String getEstudio() {
        return estudio;
    }

    // Define o estúdio do filme
    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    // Retorna o diretor do filme
    public String getDiretor() {
        return diretor;
    }

    // Define o diretor do filme
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    // Define o nome do filme
    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    // Retorna o código do filme
    public int getCodigo() {
        return codigo;
    }

    // Define o código do filme
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // Retorna o status de aluguel do filme
    public boolean isAlugado() {
        return alugado;
    }

    // Altera o status de aluguel do filme
    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    // Retorna o nome do filme
    public String getNomeFilme() {
        return nomeFilme;
    }
}
