package sdm.project.core.exceptions;

public class WrongNumberOfArgumentsException extends Exception {

    public WrongNumberOfArgumentsException() {
        super("wrong number of arguments");
    }

    public WrongNumberOfArgumentsException(String message) {
        super(message);
    }
}
