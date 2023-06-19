package net.hwyz.iov.cloud.account.service.api.facade.mp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.account.api.contract.response.LoginMpResponse;
import net.hwyz.iov.cloud.account.api.feign.mp.LoginMpApi;
import net.hwyz.iov.cloud.account.service.application.service.LoginAppService;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import net.hwyz.iov.cloud.framework.commons.bean.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 登录相关手机接口实现类
 *
 * @author hwyz_leo
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mp/login")
public class LoginMpController implements LoginMpApi {

    final LoginAppService loginAppService;

    @Override
    @PostMapping(
            value = "/sendVerifyCode",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<Void> sendVerifyCode(@RequestHeader String clientId, @RequestParam String countryRegionCode,
                                         @RequestParam String mobile) {
        logger.info("手机客户端[{}]向手机[{}:{}]发送登录验证码", clientId, countryRegionCode, mobile);
        loginAppService.sendMobileVerifyCode(clientId, CountryRegion.valOf(countryRegionCode), mobile);
        return new Response<>();
    }

    @Override
    @PostMapping(value = "/verifyCodeLogin")
    public Response<LoginMpResponse> verifyCodeLogin(@RequestHeader String clientId, @RequestParam String countryRegionCode,
                                                     @RequestParam String mobile, @RequestParam String verifyCode) {
        logger.info("手机客户端[{}]通过验证码[{}]登录手机账号[{}:{}]", clientId, verifyCode, countryRegionCode, mobile);
        LoginMpResponse loginResponse = loginAppService.mobileVerifyCodeLogin(clientId,
                CountryRegion.valOf(countryRegionCode), mobile, verifyCode);
        return new Response<>(loginResponse);
    }
}
