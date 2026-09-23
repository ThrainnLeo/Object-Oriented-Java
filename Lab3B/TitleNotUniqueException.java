package Exceptions;

public class TitleNotUniqueException extends RuntimeException{
    public TitleNotUniqueException(String message){
        super(message);
    }
}
