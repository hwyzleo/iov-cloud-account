package net.hwyz.iov.cloud.account.service.api.facade.mp;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.hwyz.iov.cloud.account.api.contract.response.LoginResponse;
import net.hwyz.iov.cloud.account.api.feign.mp.LoginApi;
import net.hwyz.iov.cloud.framework.commons.bean.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ECU控制器管理后台接口实现类
 *
 * @author hwyz_leo
 */
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/login")
public class LoginController implements LoginApi {

    @Override
    @PostMapping(value = "/sendVerifyCode")
    public Response<Void> sendVerifyCode(@RequestParam String mobile) {
        logger.info("向手机[{}]发送登录验证码", mobile);
        return new Response<>();
    }

    @Override
    @PostMapping(value = "/verifyCodeLogin")
    public Response<LoginResponse> verifyCodeLogin(@RequestParam String mobile, @RequestParam String verifyCode) {
        logger.info("手机[{}]通过验证码[{}]登录", mobile, verifyCode);
        LoginResponse loginResponse = LoginResponse.builder().mobile(mobile).token("123456").build();
        Response<LoginResponse> response = new Response<>(loginResponse);
        if ("222222".equals(verifyCode)) {
            response.setCode(1);
            response.setMessage("验证码错误");
        }
        return response;
    }
}
