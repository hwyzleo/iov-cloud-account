package net.hwyz.iov.cloud.account.service.infrastructure.exception;

/**
 * 账号不存在异常
 *
 * @author hwyz_leo
 */
public class AccountNotExistException extends AccountBaseException {
    public AccountNotExistException(String uid) {
        super(String.format("账号[%s]不存在", uid));
    }
}
