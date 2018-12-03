package produtos;

public class RepositorioArrayProduto implements InterfaceRepositoriosProduto {
    private Produto[] arrayProduto = new Produto[1000];

    public void CadastrarCatalogo(Produto produto) throws ProdutoLimiteAtingidoException, ProdutoJaExisteException {
        for (int i = 0; i < arrayProduto.length; i++) {
            if (arrayProduto[i].getNome() == produto.getNome()) {
                throw new ProdutoJaExisteException();
            } else if (arrayProduto[i] == null) {
                this.arrayProduto[i] = produto;
                break;
            } else if (i == arrayProduto.length) {
                if (arrayProduto[i] == null) {
                    this.arrayProduto[i] = produto;
                    break;
                } else {
                    throw new ProdutoLimiteAtingidoException();
                }
            }
        }
    }

    public void RemoverCatalogo(String nome) throws ProdutoNaoExisteException {
        for (int i = 0; i < arrayProduto.length; i++) {
            if (arrayProduto[i].getNome().equals(nome)) {
                for (int j = i; j < arrayProduto.length; j++) {
                    if (arrayProduto[j] != null)
                        arrayProduto[j] = arrayProduto[j + 1];
                    else
                        break;
                }
            } else if (arrayProduto[i] == null) {
                throw new ProdutoNaoExisteException();
            }
        }
    }

    public Produto Procurar(String nome) throws ProdutoNaoExisteException {
        for (int i = 0; i < arrayProduto.length; i++) {
            if (arrayProduto[i].getNome().equals(nome)) {
                return arrayProduto[i];
            } else if (arrayProduto[i] == null) {
                throw new ProdutoNaoExisteException();
            }
        }
        return null;
    }

    public boolean Existe(String nome) {
        for (int i = 0; i < arrayProduto.length; i++) {
            if (arrayProduto[i].getNome().equals(nome)) {
                return true;
            } else if (arrayProduto[i] == null) {
                return false;
            }
        }
        return false;
    }

    public void AtualizarDescricao(String nome, String novadescricao) throws ProdutoNaoExisteException {
        for (int i = 0; i < arrayProduto.length; i++) {
            if (arrayProduto[i].getNome().equals(nome)) {
                arrayProduto[i].setDescricao(novadescricao);
            } else if (arrayProduto[i] == null) {
                throw new ProdutoNaoExisteException();
            }
        }
    }

    public void AtualizarEstrelas(String nome, double novavaliacao) throws ProdutoNaoExisteException {
        for (int i = 0; i < arrayProduto.length; i++) {
            if (arrayProduto[i].getNome().equals(nome)) {
                double x = arrayProduto[i].getEstrelas();
                arrayProduto[i].setEstrelas((x + novavaliacao) / 2);
            } else if (arrayProduto[i] == null) {
                throw new ProdutoNaoExisteException();
            }
        }
    }

    public void AtualizarPreco(String nome, double novoPreco) throws ProdutoNaoExisteException {
        for (int i = 0; i < arrayProduto.length; i++) {
            if (arrayProduto[i].getNome().equals(nome)) {
                arrayProduto[i].setPreco(novoPreco);
            } else if (arrayProduto[i] == null) {
                throw new ProdutoNaoExisteException();
            }
        }
    }

    public void AtualizarQuantidade(String nome, int quantidade) throws ProdutoNaoExisteException {
        for (int i = 0; i < arrayProduto.length; i++) {
            if (arrayProduto[i].getNome().equals(nome)) {
            	if(arrayProduto[i].getQuantidade()==0) {
                    arrayProduto[i].setQuantidade(quantidade);	
            	}else {
            		int a = arrayProduto[i].getQuantidade();
            		arrayProduto[i].setQuantidade(a + quantidade);
            	}
            } else if (arrayProduto[i] == null) {
                throw new ProdutoNaoExisteException();
            }
        }
    }
}
