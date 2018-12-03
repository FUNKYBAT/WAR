package armas;
import produtos.Produto;

public class Arma extends Produto {
	protected String calibre;
	protected String categoria;
	protected String municao;
	
	public Arma(String nome,double estrelas,double preco,String descricao,String marca,String numserie,String calibre,String categoria,String municao,int quantidade) {
		super(nome,estrelas,preco,descricao,marca,numserie,quantidade);
		this.calibre = calibre;
		this.categoria = categoria;
		this.municao = municao;
	}
	public String getCalibre() {
		return calibre;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMunicao() {
		return municao;
	}

	public void setMunicao(String municao) {
		this.municao = municao;
	}

}
