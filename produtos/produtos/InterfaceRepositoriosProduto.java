package produtos;

public interface InterfaceRepositoriosProduto {

    void CadastrarCatalogo(Produto produto) throws ProdutoLimiteAtingidoException, ProdutoJaExisteException;

    void RemoverCatalogo(String nome) throws ProdutoNaoExisteException;

    Produto Procurar(String nome) throws ProdutoNaoExisteException;

    boolean Existe(String nome);

    void AtualizarPreco(String nome, double novoPreco) throws ProdutoNaoExisteException;

    void AtualizarDescricao(String nome, String novaDescricao) throws ProdutoNaoExisteException;

    void AtualizarEstrelas(String nome, double novaAvaliacao) throws ProdutoNaoExisteException;

    void AtualizarQuantidade(String nome, int quantidade) throws ProdutoNaoExisteException;

}
