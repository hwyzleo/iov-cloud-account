package net.hwyz.iov.cloud.account.service.infrastructure.cache;

import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
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
     * 获取手机登录领域对象
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

    Optional<TokenPo> getToken(ClientType clientType, String token);

    /**
     * 设置令牌数据对象
     *
     * @param tokenPo 令牌数据对象
     */
    void setToken(TokenPo tokenPo);

}
