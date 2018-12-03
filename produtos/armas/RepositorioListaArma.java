package armas;

import produtos.Produto;
import produtos.ProdutoNaoExisteException;

public class RepositorioListaArma implements InterfaceRepositoriosArma {

    private Arma arma;
    private RepositorioListaArma proximo;

    public RepositorioListaArma() {
    }

    public void CadastrarCatalogo(Arma arma) throws ArmaJaExisteException {
        if (this.arma.getNome() == null) {
            this.arma = arma;
            this.proximo = new RepositorioListaArma();
        } else if (this.arma.getNome() == arma.getNome()) {
            throw new ArmaJaExisteException();
        } else if (this.proximo != null) {
            this.proximo.CadastrarCatalogo(arma);
        }
    }

    public void RemoverCatalogo(String nome) throws ArmaNaoExisteException {
        if (this.arma != null) {
            if (this.arma.getNome().equals(nome)) {
                this.arma = this.proximo.arma;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.RemoverCatalogo(nome);
            }
        } else {
            throw new ArmaNaoExisteException();
        }
    }

    public Arma Procurar(String nome) throws ArmaNaoExisteException {
        if (this.arma != null) {
            if (this.arma.getNome().equals(nome)) {
                return this.arma;
            } else {
                this.proximo.Procurar(nome);
                return this.proximo.Procurar(nome);
            }
        } else {
            throw new ArmaNaoExisteException();
        }
    }

    public boolean Existe(String nome) {
        if (this.arma != null) {
            if (this.arma.getNome().equals(nome)) {
                return true;
            } else {
                return this.proximo.Existe(nome);
            }
        }
        return false;
    }

    public void AtualizarPreco(String nome, double novopreco) throws ArmaNaoExisteException {
        if (this.arma != null) {
            if (this.arma.getNome() == nome) {
                this.arma.setPreco(novopreco);
            } else if (this.proximo != null) {
                this.proximo.AtualizarPreco(nome, novopreco);
            }
        } else {
            throw new ArmaNaoExisteException();
        }
    }

    public void AtualizarEstrelas(String nome, double novavaliacao) throws ArmaNaoExisteException {
    	
        if (this.arma != null) {
            if (this.arma.getNome() == nome) {
                double x = this.arma.getEstrelas();
                this.arma.setEstrelas((x + novavaliacao) / 2);
            } else if (this.proximo != null) {
                this.proximo.AtualizarEstrelas(nome, novavaliacao);
            }
        } else {
            throw new ArmaNaoExisteException();
        }
    }

    public void AtualizarDescricao(String nome, String novadescricao) throws ArmaNaoExisteException {
        if (this.arma != null) {
            if (this.arma.getNome() == nome) {
                this.arma.setDescricao(novadescricao);
            } else if (this.proximo != null) {
                this.proximo.AtualizarDescricao(nome, novadescricao);
            }
        } else {
            throw new ArmaNaoExisteException();
        }
    }

    public void AtualizarQuantidade(String nome, int quantidade) throws ArmaNaoExisteException {
        if (this.arma != null) {
            if (this.arma.getNome().equals(nome)) {
            	if(this.arma.getQuantidade()==0) {
            		this.arma.setQuantidade(quantidade);	
            	}else {
            		int a = this.arma.getQuantidade();
            		this.arma.setQuantidade(a + quantidade);
            	}
            } else if (this.proximo != null) {
                this.proximo.AtualizarQuantidade(nome, quantidade);
            }
        } else {
            throw new ArmaNaoExisteException();
        }
    }
	
	public Arma[] ProcurarCategoria(String categoria,int x) throws CategoriaNaoExisteException {
		Arma[] a = new Arma[contarCat(categoria,x)];
		if (this.arma != null) { 
			if (this.arma.getCategoria() == categoria) {
				a[x] = this.arma;
				x++;
			}if (this.proximo != null) {
				this.proximo.ProcurarCategoria(categoria,x);
			}
		}
		else if (this.arma==null && x==0){
            throw new CategoriaNaoExisteException();
        }
		return a;
	}
	
	public int contarCat(String categoria,int x) {
		if (this.arma.getCategoria() == categoria) {
            x++;
        }if (this.proximo != null) {
            this.proximo.contarCat(categoria,x);
        }
        return x;
	}
	
	public Arma[] ProcurarCalibre(String calibre, int x) throws CategoriaNaoExisteException {
		Arma[] a = new Arma[contarCal(calibre,x)];
		if (this.arma != null) { 
			if (this.arma.getCalibre() == calibre) {
				a[x] = this.arma;
				x++;
			}if (this.proximo != null) {
				this.proximo.ProcurarCalibre(calibre,x);
			}
		}
		else if (this.arma==null && x==0){
            throw new CategoriaNaoExisteException();
        }
		return a;
	}
	
	public int contarCal(String calibre,int x) {
		if (this.arma.getCalibre() == calibre) {
            x++;
        }if (this.proximo != null) {
            this.proximo.contarCal(calibre,x);
        }
        return x;
	}

	public Arma[] ProcurarMunicao(String municao, int x) throws CategoriaNaoExisteException {
		Arma[] a = new Arma[contarMun(municao,x)];
		if (this.arma != null) { 
			if (this.arma.getMunicao() == municao) {
				a[x] = this.arma;
				x++;
			}if (this.proximo != null) {
				this.proximo.ProcurarMunicao(municao,x);
			}
		}
		else if (this.arma==null && x==0){
            throw new CategoriaNaoExisteException();
        }
		return a;
	}
	
	public int contarMun(String municao,int x) {
		if (this.arma.getMunicao() == municao) {
            x++;
        }if (this.proximo != null) {
            this.proximo.contarMun(municao,x);
        }
        return x;
	}

}
