package armas;

public class LimiteAtingidoException extends Exception{
    public LimiteAtingidoException(){
        super("O limite de armas no cadastradas chegou ao limite");
    }
}
