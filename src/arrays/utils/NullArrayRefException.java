package arrays.utils;

/**
 * Created by ivan on 18.04.2015.
 */
public class NullArrayRefException extends Exception{

    private String errorMessage;

    public NullArrayRefException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}