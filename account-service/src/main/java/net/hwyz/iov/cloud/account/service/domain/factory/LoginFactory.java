package net.hwyz.iov.cloud.account.service.domain.factory;

import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import net.hwyz.iov.cloud.account.service.domain.login.model.LoginDo;
import org.springframework.stereotype.Component;

/**
 * 登录领域工厂类
 *
 * @author hwyz_leo
 */
@Component
public class LoginFactory {

    /**
     * 基于手机号创建
     *
     * @param countryRegion 国家与地区
     * @param mobile        手机号
     * @return 领域对象
     */
    public LoginDo build(CountryRegion countryRegion, String mobile) {
        return LoginDo.builder()
                .countryRegion(countryRegion)
                .mobile(mobile)
                .build();
    }

}
