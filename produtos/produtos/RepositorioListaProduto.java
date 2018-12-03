package produtos;

public class RepositorioListaProduto implements InterfaceRepositoriosProduto {
    private Produto produto;
    private RepositorioListaProduto proximo;

    public RepositorioListaProduto() {
    }

    public void CadastrarCatalogo(Produto produto) throws ProdutoJaExisteException {
        if (this.produto.getNome() == null) {
            this.produto = produto;
            this.proximo = new RepositorioListaProduto();
        } else if (this.produto.getNome() == produto.getNome()) {
            throw new ProdutoJaExisteException();
        } else if (this.proximo != null) {
            this.proximo.CadastrarCatalogo(produto);
        }
    }

    public void RemoverCatalogo(String nome) throws ProdutoNaoExisteException {
        if (this.produto != null) {
            if (this.produto.getNome().equals(nome)) {
                this.produto = this.proximo.produto;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.RemoverCatalogo(nome);
            }
        } else {
            throw new ProdutoNaoExisteException();
        }
    }

    public Produto Procurar(String nome) throws ProdutoNaoExisteException {
        Produto procurado = null;
        if (this.produto != null) {
            if (this.produto.getNome().equals(nome)) {
                procurado = this.produto;
                return procurado;
            } else {
                this.proximo.Procurar(nome);
                return this.proximo.Procurar(nome);
            }
        } else {
            throw new ProdutoNaoExisteException();
        }
    }

    public boolean Existe(String nome) {
        if (this.produto != null) {
            if (this.produto.getNome().equals(nome)) {
                return true;
            } else {
                return this.proximo.Existe(nome);
            }
        } else {
            return false;
        }
    }

    public void AtualizarPreco(String nome, double novoPreco) throws ProdutoNaoExisteException {
        if (this.produto != null) {
            if (this.produto.getNome().equals(nome)) {
                this.produto.setPreco(novoPreco);
            } else if (this.proximo != null) {
                this.proximo.AtualizarPreco(nome, novoPreco);
            }
        } else {
            throw new ProdutoNaoExisteException();
        }
    }

    public void AtualizarEstrelas(String nome, double novaAvaliacao) throws ProdutoNaoExisteException {
        if (this.produto != null) {
            if (this.produto.getNome().equals(nome)) {
                double x = this.produto.getEstrelas();
                this.produto.setEstrelas((x + novaAvaliacao) / 2);
            } else if (this.proximo != null) {
                this.proximo.AtualizarEstrelas(nome, novaAvaliacao);
            }
        } else {
            throw new ProdutoNaoExisteException();
        }
    }

    public void AtualizarDescricao(String nome, String novaDescricao) throws ProdutoNaoExisteException {
        if (this.produto != null) {
            if (this.produto.getNome().equals(nome)) {
                this.produto.setDescricao(novaDescricao);
            } else if (this.proximo != null) {
                this.proximo.AtualizarDescricao(nome, novaDescricao);
            }
        } else {
            throw new ProdutoNaoExisteException();
        }
    }

    public void AtualizarQuantidade(String nome, int quantidade) throws ProdutoNaoExisteException {
        if (this.produto != null) {
            if (this.produto.getNome().equals(nome)) {
            	if(this.produto.quantidade==0) {
            		this.produto.setQuantidade(quantidade);	
            	}else {
            		int a = this.produto.quantidade;
            		this.produto.setQuantidade(a + quantidade);
            	}
            } else if (this.proximo != null) {
                this.proximo.AtualizarQuantidade(nome, quantidade);
            }
        } else {
            throw new ProdutoNaoExisteException();
        }
    }
}