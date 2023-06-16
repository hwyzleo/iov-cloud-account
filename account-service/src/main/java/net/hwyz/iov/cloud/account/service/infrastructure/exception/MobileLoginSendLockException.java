package net.hwyz.iov.cloud.account.service.infrastructure.exception;

/**
 * 手机发送登录验证码锁定异常
 *
 * @author hwyz_leo
 */
public class MobileLoginSendLockException extends AccountBaseException {
    public MobileLoginSendLockException(String mobile) {
        super(String.format("手机[%s]发送登录验证码已锁定", mobile));
    }
}
