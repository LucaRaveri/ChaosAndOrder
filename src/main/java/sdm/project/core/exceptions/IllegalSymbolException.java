package sdm.project.core.exceptions;

public class IllegalSymbolException extends Exception {

    public IllegalSymbolException(){
        super("illegal symbol");
    }

    public IllegalSymbolException(String message){
        super(message);
    }

}
