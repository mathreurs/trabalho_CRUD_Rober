package Locadora;

public class Filmes {
    int codigo;
    String nomeFilme;
    String diretor;
    String estudio;
    int anoLancamento;
    char categoria;
    boolean alugado;

    @Override
    public String toString() {
        return categoria+"," +anoLancamento + ","+ estudio +","+ diretor+","+ nomeFilme + "," +codigo + "," + alugado;
    }

    public String toText(){
        return "[categoria: " +categoria+" | ano de lançamento: " +anoLancamento + " | estudio: "+ estudio +" | diretor: "+ diretor+" | nome do filme: "+ nomeFilme + " | codigo: " +codigo+" | alugado: " + alugado + "]";
    }

    public Filmes(char categoria, int anoLancamento, String estudio, String diretor, String nomeFilme, int codigo) {
        this.categoria = categoria;
        this.anoLancamento = anoLancamento;
        this.estudio = estudio;
        this.diretor = diretor;
        this.nomeFilme = nomeFilme;
        this.codigo = codigo;
        this.alugado = alugado;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
