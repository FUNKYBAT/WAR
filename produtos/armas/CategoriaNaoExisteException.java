package armas;

public class CategoriaNaoExisteException extends Exception{
    public CategoriaNaoExisteException(){
        super("Nao existem armas com essa especificação");
    }
}
