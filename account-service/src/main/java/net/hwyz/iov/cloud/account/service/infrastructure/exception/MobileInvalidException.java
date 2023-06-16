package net.hwyz.iov.cloud.account.service.infrastructure.exception;

import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;

/**
 * 手机号码无效异常
 *
 * @author hwyz_leo
 */
public class MobileInvalidException extends AccountBaseException {
    public MobileInvalidException(String mobile, CountryRegion countryRegion) {
        super(String.format("手机号码[%s]无效[%s]", mobile, countryRegion.name));
    }
}
