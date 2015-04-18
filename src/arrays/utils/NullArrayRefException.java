package arrays.utils;

/**
 * Created by ivan on 18.04.2015.
 */
public class NullArrayRefException extends Exception{





    private String errorMessage;
    private String errorCode;

    public NullArrayRefException(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }
}