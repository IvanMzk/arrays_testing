package arrays.utils;

/**
 * Created by ivann on 16.04.15.
 */
public class NullArrayRefException extends Exception{

    private final String errorCode;

    public NullArrayRefException(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
