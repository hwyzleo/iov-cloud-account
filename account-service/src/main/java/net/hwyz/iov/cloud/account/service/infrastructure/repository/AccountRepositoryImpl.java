package net.hwyz.iov.cloud.account.service.infrastructure.repository;

import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.account.service.domain.account.model.AccountDo;
import net.hwyz.iov.cloud.account.service.domain.account.repository.AccountRepository;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import net.hwyz.iov.cloud.account.service.infrastructure.cache.CacheService;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.assembler.AccountPoAssembler;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.dao.AccountDao;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.AccountPo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 账号领域仓库接口实现类
 *
 * @author hwyz_leo
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl extends AbstractRepository<Long, AccountDo> implements AccountRepository {

    final AccountDao accountDao;
    final CacheService cacheService;

    @Override
    public Optional<AccountDo> getByMobile(CountryRegion countryRegion, String mobile) {
        logger.debug("根据手机号[{}:{}]获取登录领域对象", countryRegion.code, mobile);
        return accountDao.selectPoByExample(AccountPo.builder()
                        .countryRegionCode(countryRegion.code)
                        .mobile(mobile)
                        .build())
                .stream()
                .findFirst()
                .map(accountPo -> {
                    AccountDo accountDo = AccountPoAssembler.INSTANCE.toDo(accountPo);
                    accountDo.stateLoad();
                    return accountDo;
                });
    }

    @Override
    public Optional<AccountDo> getByUid(String uid) {
        AccountPo accountPo = cacheService.getAccount(uid).orElseGet(() -> {
            List<AccountPo> accountPoList = accountDao.selectPoByExample(AccountPo.builder().uid(uid).build());
            if (accountPoList.isEmpty()) {
                return null;
            }
            cacheService.setAccount(accountPoList.get(0));
            return accountPoList.get(0);
        });
        if (accountPo != null) {
            AccountDo accountDo = AccountPoAssembler.INSTANCE.toDo(accountPo);
            accountDo.stateLoad();
            return Optional.of(accountDo);
        }
        return Optional.empty();
    }

    @Override
    public Optional<AccountDo> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean save(AccountDo accountDo) {
        if (logger.isDebugEnabled()) {
            logger.debug("保存账号领域对象[{}]", JSONUtil.parse(accountDo).toJSONString(0));
        }
        switch (accountDo.getState()) {
            case NEW -> {
                AccountPo accountPo = AccountPoAssembler.INSTANCE.fromDo(accountDo);
                accountDao.insertPo(accountPo);
                cacheService.setAccount(accountPo);
            }
            case CHANGED -> {
                AccountPo accountPo = AccountPoAssembler.INSTANCE.fromDo(accountDo);
                accountDao.updatePo(accountPo);
                cacheService.setAccount(accountPo);
            }
            default -> {
                return false;
            }
        }
        return true;
    }
}
