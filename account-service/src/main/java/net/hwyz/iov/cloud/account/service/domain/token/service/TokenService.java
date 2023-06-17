package net.hwyz.iov.cloud.account.service.domain.token.service;

import net.hwyz.iov.cloud.account.service.domain.token.model.TokenDo;

/**
 * 令牌领域服务接口
 *
 * @author hwyz_leo
 */
public interface TokenService {

    /**
     * 创建手机端令牌
     *
     * @param uid      用户唯一ID
     * @param clientId 客户端ID
     */
    TokenDo createMobileToken(String uid, String clientId);

}
