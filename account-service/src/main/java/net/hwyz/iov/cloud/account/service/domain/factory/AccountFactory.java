package net.hwyz.iov.cloud.account.service.domain.factory;

import net.hwyz.iov.cloud.account.service.domain.account.model.AccountDo;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import org.springframework.stereotype.Component;

/**
 * 账号领域工厂类
 *
 * @author hwyz_leo
 */
@Component
public class AccountFactory {

    /**
     * 基于手机号创建
     *
     * @param countryRegion 国家与地区
     * @param mobile        手机号
     * @return 领域对象
     */
    public AccountDo build(CountryRegion countryRegion, String mobile) {
        return AccountDo.builder()
                .countryRegion(countryRegion)
                .mobile(mobile)
                .build();
    }

}
