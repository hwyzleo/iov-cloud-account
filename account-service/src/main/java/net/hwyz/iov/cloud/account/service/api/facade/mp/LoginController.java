package net.hwyz.iov.cloud.account.service.api.facade.mp;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.hwyz.iov.cloud.account.api.contract.response.LoginResponse;
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
    public Response<Void> sendVerifyCode(@RequestParam String countryRegionCode, @RequestParam String mobile) {
        logger.info("向手机[{}:{}]发送登录验证码", countryRegionCode, mobile);
        loginAppService.sendMobileVerifyCode(CountryRegion.valOf(countryRegionCode), mobile);
        return new Response<>();
    }

    @Override
    @PostMapping(value = "/verifyCodeLogin")
    public Response<MobileLoginResponse> verifyCodeLogin(@RequestParam String countryRegionCode, @RequestParam String mobile,
                                                         @RequestHeader String deviceId, @RequestParam String verifyCode) {
        logger.info("手机[{}:{}:{}]通过验证码[{}]登录", countryRegionCode, mobile, deviceId, verifyCode);
        MobileLoginResponse loginResponse = loginAppService.mobileVerifyCodeLogin(CountryRegion.valOf(countryRegionCode), mobile, deviceId, verifyCode);
        return new Response<>(loginResponse);
    }
}
