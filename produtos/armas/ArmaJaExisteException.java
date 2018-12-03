package armas;

public class ArmaJaExisteException extends Exception {
    ArmaJaExisteException(){
        super("A arma ja existe");
    }
}
