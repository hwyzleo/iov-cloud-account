package net.hwyz.iov.cloud.account.service.api.facade.mp;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.hwyz.iov.cloud.account.api.contract.response.MobileLoginResponse;
import net.hwyz.iov.cloud.account.api.feign.mp.LoginApi;
import net.hwyz.iov.cloud.account.service.application.service.LoginAppService;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import net.hwyz.iov.cloud.framework.commons.bean.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 登录相关接口实现类
 *
 * @author hwyz_leo
 */
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mp/login")
public class LoginController implements LoginApi {

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
    public Response<MobileLoginResponse> verifyCodeLogin(@RequestHeader String clientId, @RequestParam String countryRegionCode,
                                                         @RequestParam String mobile, @RequestParam String verifyCode) {
        logger.info("手机客户端[{}]通过验证码[{}]登录手机账号[{}:{}]", clientId, verifyCode, countryRegionCode, mobile);
        MobileLoginResponse loginResponse = loginAppService.mobileVerifyCodeLogin(clientId,
                CountryRegion.valOf(countryRegionCode), mobile, verifyCode);
        return new Response<>(loginResponse);
    }
}
