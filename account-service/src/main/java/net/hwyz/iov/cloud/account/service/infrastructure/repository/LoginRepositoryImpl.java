package net.hwyz.iov.cloud.account.service.infrastructure.repository;

import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import net.hwyz.iov.cloud.account.service.domain.login.model.LoginDo;
import net.hwyz.iov.cloud.account.service.domain.login.repository.LoginRepository;
import net.hwyz.iov.cloud.account.service.infrastructure.cache.CacheService;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.assembler.LoginPoAssembler;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 登录领域仓库接口实现类
 *
 * @author hwyz_leo
 */
@Log4j2
@Repository
@RequiredArgsConstructor
public class LoginRepositoryImpl extends AbstractRepository<Long, LoginDo> implements LoginRepository {

    final CacheService cacheService;

    @Override
    public Optional<LoginDo> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean save(LoginDo loginDo) {
        if (logger.isDebugEnabled()) {
            logger.debug("保存登录领域对象[{}]", JSONUtil.parse(loginDo).toJSONString(0));
        }
        switch (loginDo.getState()) {
            case NEW, CHANGED -> cacheService.setMobileLogin(LoginPoAssembler.INSTANCE.fromDo(loginDo));
            default -> {
                return false;
            }
        }
        return true;
    }

    @Override
    public Optional<LoginDo> getByMobile(CountryRegion countryRegion, String mobile) {
        logger.debug("根据手机号[{}:{}]获取登录领域对象", countryRegion.code, mobile);
        return cacheService.getMobileLogin(countryRegion, mobile).map(loginPo -> {
            LoginDo loginDo = LoginPoAssembler.INSTANCE.toDo(loginPo);
            loginDo.stateLoad();
            return loginDo;
        });
    }
}
