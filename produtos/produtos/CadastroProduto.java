package produtos;
import produtos.*;

public class CadastroProduto {	
	private InterfaceRepositoriosProduto lista;
	
	public CadastroProduto(boolean tipo) {
        if (tipo) {
            this.lista = new RepositorioListaProduto();
        } else {
            this.lista = new RepositorioArrayProduto();
        }
    }
	

    public void AtualizarQuantidadeProduto (String nome, int quantidade) throws ProdutoNaoExisteException {
        this.lista.AtualizarQuantidade(nome, quantidade);
    }

    public void atualizaDescricaoProduto (String nome, String novaDescricao) throws ProdutoNaoExisteException {
        this.lista.AtualizarDescricao(nome, novaDescricao);
    }
    
    public void AtualizarEstrelasProduto(String nome, double novaAvaliacao) throws ProdutoNaoExisteException {
        this.lista.AtualizarEstrelas(nome, novaAvaliacao);
    }

    public void AtualizarPrecoProduto(String nome, double novoPreco) throws ProdutoNaoExisteException {
        this.lista.AtualizarPreco(nome,novoPreco);
    }

    public boolean existeProduto (String nome) {
        return this.lista.Existe(nome);
    }
    public Produto procurarProduto (String nome) throws ProdutoNaoExisteException {
        return this.lista.Procurar(nome);
    }
    public void removerProduto(String nome) throws ProdutoNaoExisteException {
        this.lista.RemoverCatalogo(nome);
    }
    public void cadastrarProduto(Produto produto) throws  ProdutoJaExisteException, ProdutoLimiteAtingidoException{
        this.lista.CadastrarCatalogo(produto);
    }

}
