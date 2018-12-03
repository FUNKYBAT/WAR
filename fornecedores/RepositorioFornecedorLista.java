package fornecedores;

public class RepositorioFornecedorLista implements RepositorioFornecedorInterface {
    Fornecedor fornecedor;
    RepositorioFornecedorLista proximo;

    public RepositorioFornecedorLista() {
    }

    @Override
    public void inserir(Fornecedor fornecedor) throws ExceptionFornecedorJaCadastrado {
        if (this.fornecedor == null) {
            this.fornecedor = fornecedor;
            this.proximo = new RepositorioFornecedorLista();
        } else if (this.fornecedor.getMarca() == fornecedor.getMarca()) {
            throw new ExceptionFornecedorJaCadastrado();
        } else if (this.proximo != null) {
            this.proximo.inserir(fornecedor);
        }
    }

    @Override
    public Fornecedor procurar(String marca) throws ExceptionFornecedorNaoExiste {
        if (this.fornecedor.getMarca().equals(marca)) {
            return this.fornecedor;
        } else if (this.proximo != null) {
            this.proximo.procurar(marca);
        } else {
            throw new ExceptionFornecedorNaoExiste();
        }
        return null; // Caso base.
    }

    @Override
    public void deletar(String marca) throws ExceptionFornecedorNaoExiste {
        if (this.fornecedor != null) {
            if (this.fornecedor.getMarca().equals(marca)) {
                this.fornecedor = this.proximo.fornecedor;
                this.proximo = this.proximo.proximo;
            } else if (this.proximo != null) {
                this.proximo.deletar(marca);
            } else {
                throw new ExceptionFornecedorNaoExiste();
            }
        }
    }

    @Override
    public void atualizaMarca(String marca, String novaMarca) throws ExceptionFornecedorNaoExiste {
        if (this.fornecedor.getMarca() != null) {
            if (this.fornecedor.getMarca().equals(marca)) {
                this.fornecedor.setMarca(novaMarca);
            } else {
                this.proximo.atualizaMarca(marca, novaMarca);
            }
        } else {
            throw new ExceptionFornecedorNaoExiste();
        }
    }

    @Override
    public void atualizaContato(String marca, String contato) throws ExceptionFornecedorNaoExiste {
        if (this.fornecedor.getMarca() != null) {
            if (this.fornecedor.getMarca().equals(marca)) {
                this.fornecedor.setContato(contato);
            } else {
                this.proximo.atualizaContato(marca, contato);
            }
        } else {
            throw new ExceptionFornecedorNaoExiste();
        }
    }

    @Override
    public void atualizaTipoProduto(String marca, String tipoProduto) throws ExceptionFornecedorNaoExiste {
        if (this.fornecedor.getMarca() != null) {
            if (this.fornecedor.getMarca().equals(marca)) {
                this.fornecedor.setTipoProduto(tipoProduto);
            } else {
                this.proximo.atualizaTipoProduto(marca, tipoProduto);
            }
        } else {
            throw new ExceptionFornecedorNaoExiste();
        }
    }

    @Override
    public void atualizaDisponibilidade(String marca, boolean disponibilidade) throws ExceptionFornecedorNaoExiste {
        if (this.fornecedor.getMarca() != null) {
            if (this.fornecedor.getMarca().equals(marca)) {
                this.fornecedor.setDisponibilidade(disponibilidade);
            } else {
                this.proximo.atualizaDisponibilidade(marca, disponibilidade);
            }
        } else {
            throw new ExceptionFornecedorNaoExiste();
        }
    }
}