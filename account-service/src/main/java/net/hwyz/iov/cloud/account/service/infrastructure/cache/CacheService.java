package net.hwyz.iov.cloud.account.service.infrastructure.cache;

import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.AccountPo;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.LoginPo;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.TokenPo;
import net.hwyz.iov.cloud.framework.commons.enums.ClientType;

import java.util.Optional;

/**
 * 缓存服务接口
 *
 * @author hwyz_leo
 */
public interface CacheService {

    /**
     * 获取手机登录数据对象
     *
     * @param countryRegion 国家或地区
     * @param mobile        手机号
     * @return 登录领域对象
     */
    Optional<LoginPo> getMobileLogin(CountryRegion countryRegion, String mobile);

    /**
     * 设置手机登录数据对象
     *
     * @param loginPo 登录数据对象
     */
    void setMobileLogin(LoginPo loginPo);

    /**
     * 获取令牌数据对象
     *
     * @param clientType 客户端类型
     * @param token      令牌
     * @return 令牌数据对象
     */
    Optional<TokenPo> getToken(ClientType clientType, String token);

    /**
     * 设置令牌数据对象
     *
     * @param tokenPo 令牌数据对象
     */
    void setToken(TokenPo tokenPo);

    /**
     * 获取账号数据对象
     *
     * @param uid 账号唯一ID
     * @return 账号数据对象
     */
    Optional<AccountPo> getAccount(String uid);

    /**
     * 设置账号数据对象
     *
     * @param accountPo 账号数据对象
     */
    void setAccount(AccountPo accountPo);

}
