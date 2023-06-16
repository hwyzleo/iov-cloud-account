package net.hwyz.iov.cloud.account.service.domain.factory;

import net.hwyz.iov.cloud.account.service.domain.contract.enums.TokenType;
import net.hwyz.iov.cloud.account.service.domain.token.model.TokenDo;
import org.springframework.stereotype.Component;

/**
 * 令牌领域工厂类
 *
 * @author hwyz_leo
 */
@Component
public class TokenFactory {

    /**
     * 创建手机令牌
     *
     * @param uid      账号唯一ID
     * @param clientId 客户端ID
     * @return 令牌领域对象
     */
    public TokenDo buildMobile(String uid, String clientId) {
        return TokenDo.builder()
                .uid(uid)
                .clientId(clientId)
                .tokenType(TokenType.MOBILE)
                .build();
    }

}
