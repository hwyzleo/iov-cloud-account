package net.hwyz.iov.cloud.account.service.domain.token.repository;

import net.hwyz.iov.cloud.account.service.domain.contract.BaseRepository;
import net.hwyz.iov.cloud.account.service.domain.token.model.TokenDo;

/**
 * 令牌领域仓库接口
 *
 * @author hwyz_leo
 */
public interface TokenRepository extends BaseRepository<Long, TokenDo> {
}
