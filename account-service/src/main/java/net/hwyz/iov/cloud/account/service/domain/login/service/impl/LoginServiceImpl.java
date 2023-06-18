package net.hwyz.iov.cloud.account.service.domain.login.service.impl;

import cn.hutool.core.collection.ListUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import net.hwyz.iov.cloud.account.service.domain.external.service.ExMnoService;
import net.hwyz.iov.cloud.account.service.domain.factory.LoginFactory;
import net.hwyz.iov.cloud.account.service.domain.login.model.LoginDo;
import net.hwyz.iov.cloud.account.service.domain.login.repository.LoginRepository;
import net.hwyz.iov.cloud.account.service.domain.login.service.LoginService;
import net.hwyz.iov.cloud.account.service.infrastructure.exception.MobileLoginSendLockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 登录领域服务接口实现类
 *
 * @author hwyz_leo
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    final LoginFactory factory;
    final ExMnoService mnoService;
    final LoginRepository repository;

    @Value("${loginSmsTemplateId:1}")
    private String loginSmsTemplateId;

    @Override
    public void sendMobileVerifyCode(String clientId, CountryRegion countryRegion, String mobile) {
        logger.info("手机设备[{}]向手机[{}:{}]发送登录验证码", clientId, countryRegion.code, mobile);
        LoginDo loginDo = repository.getByMobile(countryRegion, mobile).orElseGet(() -> {
            LoginDo newLoginDo = factory.build(countryRegion, mobile);
            newLoginDo.init();
            return newLoginDo;
        });
        if (loginDo.isMobileLock()) {
            throw new MobileLoginSendLockException(mobile);
        }
        String verifyCode = loginDo.generateVerifyCode();
        mnoService.sendSms(loginSmsTemplateId, countryRegion.code, mobile, ListUtil.of(verifyCode));
        loginDo.sendVerifyCode();
        repository.save(loginDo);
    }

    @Override
    public boolean verifyMobileVerifyCode(CountryRegion countryRegion, String mobile, String verifyCode) {
        logger.info("验证手机[{}:{}]登录验证码[{}]", countryRegion.code, mobile, verifyCode);
        Optional<LoginDo> loginOptional = repository.getByMobile(countryRegion, mobile);
        if (loginOptional.isPresent()) {
            LoginDo loginDo = loginOptional.get();
            boolean verifyResult = loginDo.verifyCode(verifyCode);
            repository.save(loginDo);
            return verifyResult;
        }
        return false;
    }
}
