package net.hwyz.iov.cloud.account.service.domain.account.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.hwyz.iov.cloud.account.service.domain.account.model.AccountDo;
import net.hwyz.iov.cloud.account.service.domain.account.repository.AccountRepository;
import net.hwyz.iov.cloud.account.service.domain.account.service.AccountService;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import net.hwyz.iov.cloud.account.service.domain.factory.AccountFactory;
import org.springframework.stereotype.Service;

/**
 * 账号领域服务接口实现类
 *
 * @author hwyz_leo
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    final AccountFactory factory;
    final AccountRepository repository;

    @Override
    public AccountDo getOrCreate(CountryRegion countryRegion, String mobile) {
        logger.info("根据手机号[{}:{}]获取或创建账号", countryRegion.code, mobile);
        return repository.getByMobile(countryRegion, mobile).orElseGet(() -> {
            AccountDo newAccountDo = factory.build(countryRegion, mobile);
            newAccountDo.init();
            repository.save(newAccountDo);
            return newAccountDo;
        });
    }
}
