package inheritance;

public class InvalidDepositException extends IllegalArgumentException {
    public InvalidDepositException(){
        super();
    }

    public InvalidDepositException(String error){
        super(error);

    }
}
