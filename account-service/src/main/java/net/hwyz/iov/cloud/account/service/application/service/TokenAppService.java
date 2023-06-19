package net.hwyz.iov.cloud.account.service.application.service;

import lombok.RequiredArgsConstructor;
import net.hwyz.iov.cloud.account.api.contract.UserIdentity;
import net.hwyz.iov.cloud.account.service.domain.token.model.TokenDo;
import net.hwyz.iov.cloud.account.service.domain.token.service.TokenService;
import net.hwyz.iov.cloud.framework.commons.enums.ClientType;
import org.springframework.stereotype.Service;

/**
 * 令牌应用服务类
 *
 * @author hwyz_leo
 */
@Service
@RequiredArgsConstructor
public class TokenAppService {

    final TokenService tokenService;

    /**
     * 令牌身份认证
     *
     * @param token    令牌
     * @param clientId 客户端ID
     * @return 用户身份
     */
    public UserIdentity authenticateMp(String token, String clientId) {
        return tokenService.validateToken(token, ClientType.MP, clientId)
                .map(tokenDo -> UserIdentity.builder()
                        .uid(tokenDo.getUid())
                        .build())
                .orElse(UserIdentity.builder().build());
    }

}
