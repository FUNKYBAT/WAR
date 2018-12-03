package produtos;

public class ProdutoLimiteAtingidoException extends Exception {
    public ProdutoLimiteAtingidoException(){
        super("O limite de acessorios cadastrados foi atingido");
    }
}
