package armas;

public class ArmaNaoExisteException extends Exception{
    ArmaNaoExisteException(){
        super("A arma nao existe");
    }
}
