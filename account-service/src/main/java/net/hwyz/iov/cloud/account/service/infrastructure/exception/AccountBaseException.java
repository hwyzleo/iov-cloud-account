package net.hwyz.iov.cloud.account.service.infrastructure.exception;

/**
 * 账号服务基础异常
 *
 * @author hwyz_leo
 */
public class AccountBaseException extends RuntimeException {

    private static final int ERROR_CODE = 100000;

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误消息
     */
    private String message;

    public AccountBaseException(String message) {
        this.code = ERROR_CODE;
        this.message = message;
    }

    public AccountBaseException(int errorCode, String message) {
        this.code = errorCode;
        this.message = message;
    }

}
