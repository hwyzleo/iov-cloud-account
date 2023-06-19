package net.hwyz.iov.cloud.account.api.feign.service;

import net.hwyz.iov.cloud.account.api.contract.UserIdentity;
import net.hwyz.iov.cloud.account.api.contract.request.AuthenticationRequest;
import net.hwyz.iov.cloud.framework.commons.enums.ClientType;

/**
 * 令牌相关服务接口
 *
 * @author hwyz_leo
 */
public interface TokenServiceApi {

    /**
     * 手机令牌身份认证
     *
     * @param authenticationRequest 身份认证请求
     * @return 用户身份
     */
    UserIdentity authenticateMp(AuthenticationRequest authenticationRequest);

}
