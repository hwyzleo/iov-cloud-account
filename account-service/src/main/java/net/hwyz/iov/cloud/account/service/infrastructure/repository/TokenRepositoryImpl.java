package net.hwyz.iov.cloud.account.service.infrastructure.repository;

import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.hwyz.iov.cloud.account.service.domain.token.model.TokenDo;
import net.hwyz.iov.cloud.account.service.domain.token.repository.TokenRepository;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.assembler.TokenPoAssembler;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.dao.TokenDao;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 令牌领域仓库接口实现类
 *
 * @author hwyz_leo
 */
@Log4j2
@Repository
@RequiredArgsConstructor
public class TokenRepositoryImpl extends AbstractRepository<Long, TokenDo> implements TokenRepository {

    final TokenDao tokenDao;

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
            case NEW -> tokenDao.insertPo(TokenPoAssembler.INSTANCE.fromDo(tokenDo));
            default -> {
                return false;
            }
        }
        return true;
    }

}
