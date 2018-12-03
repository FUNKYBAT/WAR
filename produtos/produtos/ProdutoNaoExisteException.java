package produtos;

public class ProdutoNaoExisteException extends Exception {
    public ProdutoNaoExisteException(){
        super("O acessório já existe no sistema");
    }
}
