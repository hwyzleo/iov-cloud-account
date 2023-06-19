package net.hwyz.iov.cloud.account.service.domain.account.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.account.service.domain.account.model.AccountDo;
import net.hwyz.iov.cloud.account.service.domain.account.repository.AccountRepository;
import net.hwyz.iov.cloud.account.service.domain.account.service.AccountService;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import net.hwyz.iov.cloud.account.service.domain.factory.AccountFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 账号领域服务接口实现类
 *
 * @author hwyz_leo
 */
@Slf4j
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

    @Override
    public Optional<AccountDo> get(String uid) {
        logger.info("根据UID[{}]获取账号", uid);
        return repository.getByUid(uid);
    }
}
