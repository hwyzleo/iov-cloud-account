package net.hwyz.iov.cloud.account.service.application.service;

import cn.hutool.core.util.PhoneUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.hwyz.iov.cloud.account.api.contract.response.MobileLoginResponse;
import net.hwyz.iov.cloud.account.service.domain.account.model.AccountDo;
import net.hwyz.iov.cloud.account.service.domain.account.service.AccountService;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import net.hwyz.iov.cloud.account.service.domain.external.service.ExSecurityService;
import net.hwyz.iov.cloud.account.service.domain.factory.AccountFactory;
import net.hwyz.iov.cloud.account.service.domain.login.service.LoginService;
import net.hwyz.iov.cloud.account.service.domain.token.model.TokenDo;
import net.hwyz.iov.cloud.account.service.domain.token.service.TokenService;
import net.hwyz.iov.cloud.account.service.infrastructure.exception.MobileInvalidException;
import net.hwyz.iov.cloud.account.service.infrastructure.exception.MobileLoginVerifyCodeIncorrectException;
import org.springframework.stereotype.Service;

/**
 * 登录应用服务类
 *
 * @author hwyz_leo
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class LoginAppService {

    final LoginService loginService;
    final TokenService tokenService;
    final AccountFactory accountFactory;
    final AccountService accountService;
    final ExSecurityService securityService;

    /**
     * 发送手机登录验证码
     *
     * @param countryRegion 国家或地区
     * @param mobile        手机号
     */
    public void sendMobileVerifyCode(CountryRegion countryRegion, String mobile) {
        checkMobile(countryRegion, mobile);
        loginService.sendMobileVerifyCode(countryRegion, mobile);
    }

    /**
     * 手机验证码登录
     *
     * @param countryRegion 国家或地区
     * @param mobile        手机号
     * @param clientId      客户端ID
     * @param verifyCode    验证码
     * @return 登录响应
     */
    public MobileLoginResponse mobileVerifyCodeLogin(CountryRegion countryRegion, String mobile, String clientId, String verifyCode) {
        checkMobile(countryRegion, mobile);
        boolean verifySuccess = loginService.verifyMobileVerifyCode(countryRegion, mobile, verifyCode);
        if (verifySuccess) {
            AccountDo accountDo = accountService.getOrCreate(countryRegion, mobile);
            byte[] mobileKey = securityService.getMobileKey(accountDo.getUid(), clientId);
            TokenDo tokenDo = tokenService.createMobileToken(accountDo.getUid(), clientId, mobileKey);
            return MobileLoginResponse.builder()
                    .mobile(mobile)
                    .token(tokenDo.getAccessToken())
                    .tokenExpires(tokenDo.getAccessTokenExpires())
                    .refreshToken(tokenDo.getRefreshToken())
                    .refreshTokenExpires(tokenDo.getRefreshTokenExpires())
                    .build();
        }
        throw new MobileLoginVerifyCodeIncorrectException(countryRegion, mobile);
    }

    /**
     * 检查手机号格式
     *
     * @param countryRegion 国家或地区
     * @param mobile        手机号
     */
    private void checkMobile(CountryRegion countryRegion, String mobile) {
        logger.info("检查国家或地区[{}]手机号[{}]有效性", countryRegion.name, mobile);
        boolean mobileInvalid = switch (countryRegion) {
            case CHINESE_MAINLAND -> !PhoneUtil.isMobile(mobile);
            case CHINESE_HONG_KONG -> !PhoneUtil.isMobileHk(mobile);
            case CHINESE_MACAU -> !PhoneUtil.isMobileMo(mobile);
            case CHINESE_TAIWAN -> !PhoneUtil.isMobileTw(mobile);
        };
        if (mobileInvalid) {
            throw new MobileInvalidException(mobile, countryRegion);
        }
    }

}
