package net.hwyz.iov.cloud.account.service.domain.account.service;

import net.hwyz.iov.cloud.account.service.domain.account.model.AccountDo;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;

import java.util.Optional;

/**
 * 账号领域服务接口
 *
 * @author hwyz_leo
 */
public interface AccountService {

    /**
     * 获取或新建领域对象
     *
     * @param countryRegion 国家或地区
     * @param mobile        手机号
     * @return 账号领域对象
     */
    AccountDo getOrCreate(CountryRegion countryRegion, String mobile);

    /**
     * 通过UID获取账号领域对象
     *
     * @param uid 账号唯一ID
     * @return 账号领域对象
     */
    Optional<AccountDo> get(String uid);

}
