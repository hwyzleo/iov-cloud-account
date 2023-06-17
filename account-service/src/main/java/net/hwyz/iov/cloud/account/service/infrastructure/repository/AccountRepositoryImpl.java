package net.hwyz.iov.cloud.account.service.infrastructure.repository;

import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.hwyz.iov.cloud.account.service.domain.account.model.AccountDo;
import net.hwyz.iov.cloud.account.service.domain.account.repository.AccountRepository;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.assembler.AccountPoAssembler;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.dao.AccountDao;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.AccountPo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 账号领域仓库接口实现类
 *
 * @author hwyz_leo
 */
@Log4j2
@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl extends AbstractRepository<Long, AccountDo> implements AccountRepository {

    final AccountDao accountDao;

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
    public Optional<AccountDo> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean save(AccountDo accountDo) {
        if (logger.isDebugEnabled()) {
            logger.debug("保存账号领域对象[{}]", JSONUtil.parse(accountDo).toJSONString(0));
        }
        switch (accountDo.getState()) {
            case NEW -> accountDao.insertPo(AccountPoAssembler.INSTANCE.fromDo(accountDo));
            default -> {
                return false;
            }
        }
        return true;
    }
}
