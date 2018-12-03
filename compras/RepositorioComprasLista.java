package compras;

import java.util.Random;

import produto.Produto;

public class RepositorioComprasLista implements RepositorioComprasInterface {
	private Produto produto;
	private int qtdProduto; // Armazenar qtd do produto por loop
	private RepositorioComprasLista proximo;

	public RepositorioComprasLista() {
	}

	// Adicionar Item no Carrinho
	@Override
	public void adicionarItem(Produto produto) {
		if (this.produto.getNome() == null) {
			this.produto = produto;
			this.proximo = new RepositorioComprasLista();
		} else if (this.produto.getNome() == produto.getNome()) {
			qtdProduto++;
		}

	}

	// Remover Item do Carrinho
	@Override
	public void removerItem(String nome) throws ItemNaoEstaNoCarrinhoException {
		if (this.produto != null) {
			if (this.produto.getNome().equals(nome)) {
				this.produto = this.proximo.produto;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.removerItem(nome);
			}
		} else {
			throw new ItemNaoEstaNoCarrinhoException();
		}
	}

	// Procurar Item no Carrinho
	@Override
	public Produto procurarItem(String nome) throws ItemNaoEstaNoCarrinhoException {
		Produto p = null;
		if (this.produto != null) {
			if (this.produto.getNome().equals(nome)) {
				p = this.produto;
				return p;
			} else {
				this.proximo.procurarItem(nome);
				return this.proximo.procurarItem(nome);
			}
		} else {
			throw new ItemNaoEstaNoCarrinhoException();
		}
	}

	// Verificar se item existe no carrinho
	@Override
	public boolean existe(String nome) {
		if (this.produto != null) {
			if (this.produto.getNome().equals(nome)) {
				return true;
			} else {
				return this.proximo.existe(nome);
			}
		} else {
			return false;
		}
	}

	// Adicionar cupom de Desconto
	@Override
	public int inserirCupom(int codCupom) {
		Random geradorDesconto = new Random();
		int valorDesconto = geradorDesconto.nextInt(5);
		return valorDesconto;
	}

	// Calcular Frete de envio
	@Override
	public int calcularFrete(int cep) {
		Random geradorFrete = new Random();
		int valor = geradorFrete.nextInt(20);
		return valor;
	}

}