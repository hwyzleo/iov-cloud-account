package net.hwyz.iov.cloud.account.service.domain.token.repository;

import net.hwyz.iov.cloud.account.service.domain.contract.BaseRepository;
import net.hwyz.iov.cloud.account.service.domain.token.model.TokenDo;
import net.hwyz.iov.cloud.framework.commons.enums.ClientType;

import java.util.Optional;

/**
 * 令牌领域仓库接口
 *
 * @author hwyz_leo
 */
public interface TokenRepository extends BaseRepository<Long, TokenDo> {

    /**
     * 获取令牌
     *
     * @param token      令牌
     * @param clientType 客户端类型
     * @param clientId   客户端ID
     * @return 令牌领域对象
     */
    Optional<TokenDo> getToken(String token, ClientType clientType, String clientId);

}
