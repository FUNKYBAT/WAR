package compras;

import produto.Produto;
import java.util.Random;
import armas.Armas;

public class RepositorioComprasArray implements RepositorioComprasInterface {
	private Produto[] arrayCarrinho = new Produto[1000]; // Compras de Acessórios
	private int[] arrayQtdProduto = new int[arrayCarrinho.length]; // Armazenar qtd do produto por índice
	private Armas[] arrayCarinho2 = new Armas[1000]; // Compras de Armas

	// Adicionar Item no Carrinho
	public void adicionarItem(Produto produto) {
		for (int i = 0; i < arrayCarrinho.length; i++) {
			if (this.arrayCarrinho[i].getNome().equals(produto)) {
				this.arrayQtdProduto[i] += 1; // Este código adiciona qtd no índice do produto
			} else {
				this.arrayCarrinho[i] = produto;
				this.arrayQtdProduto[i] = 1; // Este código adiciona qtd no índice do produto
			}
		}
	}

	// Remover Item do Carrinho
	@Override
	public void removerItem(String nome) throws ItemNaoEstaNoCarrinhoException {
		for (int i = 0; i < this.arrayCarrinho.length; i++) {
			if (this.arrayCarrinho[i].getNome().equals(nome)) {
				int aux = i;
				for (int j = 1; j < (this.arrayCarrinho.length - aux); j++) {
					this.arrayCarrinho[aux] = this.arrayCarrinho[aux + 1];
					aux++;
				}
			} else {
				throw new ItemNaoEstaNoCarrinhoException();
			}
		}
	}

	// Procurar Item no Carrinho
	@Override
	public Produto procurarItem(String nome) throws ItemNaoEstaNoCarrinhoException {
		for (int i = 0; i < this.arrayCarrinho.length; i++) {
			if (this.arrayCarrinho[i].getNome().equals(nome)) {
				return this.arrayCarrinho[i];
			} else {
				throw new ItemNaoEstaNoCarrinhoException();
			}
		}
		return null;
	}

	// Verificar se item existe no carrinho
	@Override
	public boolean existe(String nome) {
		for (int i = 0; i < this.arrayCarrinho.length; i++) {
			if (this.arrayCarrinho[i].getNome().equals(nome)) {
				return true;
			} else if (this.arrayCarrinho[i] == null) {
				return false;
			}
		}
		return false;
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