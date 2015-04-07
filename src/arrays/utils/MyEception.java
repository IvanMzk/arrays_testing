package arrays.utils;

/**
 * Created by ivan on 07.04.15.
 */
public class MyEception extends Exception{

    private final String errorCode;

    public MyEception(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}