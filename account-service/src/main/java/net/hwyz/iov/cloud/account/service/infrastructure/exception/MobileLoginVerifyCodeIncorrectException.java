package net.hwyz.iov.cloud.account.service.infrastructure.exception;

import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;

/**
 * 手机登录验证码不正确异常
 *
 * @author hwyz_leo
 */
public class MobileLoginVerifyCodeIncorrectException extends AccountBaseException {
    public MobileLoginVerifyCodeIncorrectException(CountryRegion countryRegion, String mobile) {
        super(String.format("手机[%s:%s]登录验证码验证失败", countryRegion.code, mobile));
    }
}
