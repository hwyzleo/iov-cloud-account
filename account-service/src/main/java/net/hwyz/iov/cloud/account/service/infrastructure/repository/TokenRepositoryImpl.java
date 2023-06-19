package net.hwyz.iov.cloud.account.service.infrastructure.repository;

import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.account.service.domain.token.model.TokenDo;
import net.hwyz.iov.cloud.account.service.domain.token.repository.TokenRepository;
import net.hwyz.iov.cloud.account.service.infrastructure.cache.CacheService;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.assembler.TokenPoAssembler;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.dao.TokenDao;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.TokenPo;
import net.hwyz.iov.cloud.framework.commons.enums.ClientType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 令牌领域仓库接口实现类
 *
 * @author hwyz_leo
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class TokenRepositoryImpl extends AbstractRepository<Long, TokenDo> implements TokenRepository {

    final TokenDao tokenDao;
    final CacheService cacheService;

    @Override
    public Optional<TokenDo> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean save(TokenDo tokenDo) {
        if (logger.isDebugEnabled()) {
            logger.debug("保存令牌领域对象[{}]", JSONUtil.parse(tokenDo).toJSONString(0));
        }
        switch (tokenDo.getState()) {
            case NEW -> {
                TokenPo tokenPo = TokenPoAssembler.INSTANCE.fromDo(tokenDo);
                tokenDao.insertPo(tokenPo);
                cacheService.setToken(tokenPo);
            }
            default -> {
                return false;
            }
        }
        return true;
    }

    @Override
    public Optional<TokenDo> getToken(String token, ClientType clientType, String clientId) {
        TokenPo tokenPo = cacheService.getToken(clientType, token).orElseGet(() -> {
            List<TokenPo> tokenPoList = tokenDao.selectPoByExample(TokenPo.builder()
                    .accessToken(token)
                    .clientType(clientType.name())
                    .build());
            return tokenPoList.isEmpty() ? null : tokenPoList.get(0);
        });
        if (tokenPo != null) {
            if (tokenPo.getClientId().equals(clientId)) {
                return Optional.of(TokenPoAssembler.INSTANCE.toDo(tokenPo));
            }
            logger.warn("客户端[{}]令牌[{}]的客户端ID不一致[{}:{}]", clientType, token, tokenPo.getClientId(), clientId);
        }
        return Optional.empty();
    }
}
