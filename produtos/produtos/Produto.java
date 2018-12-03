package produtos;

public class Produto {
    protected String nome;
    protected double estrelas; //avaliacao
    protected double preco;
    protected String descricao;
    protected String marca; //fabricante
    protected String numserie;
    protected int quantidade;

    public Produto(String nome, double estrelas, double preco, String descricao, String marca, String numSerie, int quantidade) {
        this.nome = nome;
        this.estrelas = estrelas;
        this.preco = preco;
        this.descricao = descricao;
        this.marca = marca;
        this.numserie = numSerie;
        this.quantidade = quantidade;
    }

    public String getNumserie() {
        return numserie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(double estrelas) {
        this.estrelas = estrelas;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
