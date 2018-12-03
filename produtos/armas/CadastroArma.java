package armas;

import armas.*;

public class CadastroArma {
private InterfaceRepositoriosArma lista;
	
	public CadastroArma(boolean tipo) {
        if (tipo) {
            this.lista = new RepositorioListaArma();
        } else {
            this.lista = new RepositorioArrayArma();
        }
    }

    public void cadastrarArma(Arma arma) throws ArmaJaExisteException,  LimiteAtingidoException{
        this.lista.CadastrarCatalogo(arma);
    }


    public void removerArma(String nome) throws ArmaNaoExisteException {
        this.lista.RemoverCatalogo(nome);
    }


    public Arma procurarArma (String nome) throws ArmaNaoExisteException {
        return this.lista.Procurar(nome);
    }

    public boolean existeArma (String nome) {
        return this.lista.Existe(nome);
    }

    public void AtualizarPrecoArma(String nome, double novoPreco) throws ArmaNaoExisteException {
        this.lista.AtualizarPreco(nome,novoPreco);
    }

    public void AtualizarEstrelasArma(String nome, double novaAvaliacao) throws ArmaNaoExisteException {
        this.lista.AtualizarEstrelas(nome, novaAvaliacao);
    }

    public void atualizaDescricaoArma (String nome, String novaDescricao) throws ArmaNaoExisteException {
        this.lista.AtualizarDescricao(nome, novaDescricao);
    }

    public void AtualizarQuantidadeArma(String nome, int quantidade) throws ArmaNaoExisteException {
        this.lista.AtualizarQuantidade(nome, quantidade);
    }

    public void ProcurarCategoriaArma(String categoria,int  x) throws CategoriaNaoExisteException {
        this.lista.ProcurarCategoria(categoria, x);
    }

    public void ProcurarCalibreArma(String calibre,int  x) throws CategoriaNaoExisteException {
        this.lista.ProcurarCalibre(calibre, x);
    }
    
    public void ProcurarMunicaoArma(String municao,int  x) throws CategoriaNaoExisteException {
        this.lista.ProcurarMunicao(municao, x);
    }
}
