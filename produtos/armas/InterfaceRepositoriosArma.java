package armas;
import armas.*;

public interface InterfaceRepositoriosArma {

    void CadastrarCatalogo(Arma arma) throws ArmaJaExisteException, LimiteAtingidoException;

    void RemoverCatalogo(String nome) throws ArmaNaoExisteException;

    Arma Procurar(String nome) throws ArmaNaoExisteException;

    boolean Existe(String nome);

    void AtualizarPreco(String nome, double novoPreco) throws ArmaNaoExisteException;

    void AtualizarDescricao(String nome, String novaDescricao) throws ArmaNaoExisteException;

    void AtualizarEstrelas(String nome, double novaAvaliacao) throws ArmaNaoExisteException;

	void AtualizarQuantidade(String nome, int quantidade) throws ArmaNaoExisteException;

	Arma[] ProcurarCategoria(String categoria, int x) throws CategoriaNaoExisteException;

	Arma[] ProcurarCalibre(String calibre, int x) throws CategoriaNaoExisteException;

	Arma[] ProcurarMunicao(String municao, int x) throws CategoriaNaoExisteException;

    
}
