package net.hwyz.iov.cloud.account.service.api.facade.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.account.api.contract.UserIdentity;
import net.hwyz.iov.cloud.account.api.contract.request.AuthenticationRequest;
import net.hwyz.iov.cloud.account.api.feign.service.TokenServiceApi;
import net.hwyz.iov.cloud.account.service.application.service.TokenAppService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 令牌相关服务接口实现类
 *
 * @author hwyz_leo
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/service/token")
public class TokenServiceController implements TokenServiceApi {

    final TokenAppService tokenAppService;

    @Override
    @PostMapping(value = "/authenticateMp")
    public UserIdentity authenticateMp(@RequestBody @Valid AuthenticationRequest authenticationRequest) {
        logger.info("手机端[{}]令牌[{}]身份认证", authenticationRequest.getClientId(), authenticationRequest.getToken());
        return tokenAppService.authenticateMp(authenticationRequest.getToken(), authenticationRequest.getClientId());
    }

}
