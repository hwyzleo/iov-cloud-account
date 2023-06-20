package net.hwyz.iov.cloud.account.service.api.facade.mp;

import cn.hutool.core.map.MapUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.account.api.contract.AccountInfoMp;
import net.hwyz.iov.cloud.account.api.feign.mp.AccountMpApi;
import net.hwyz.iov.cloud.account.service.application.service.AccountAppService;
import net.hwyz.iov.cloud.framework.commons.bean.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 账户相关手机接口实现类
 *
 * @author hwyz_leo
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mp/account")
public class AccountMpController implements AccountMpApi {

    final AccountAppService accountAppService;

    @Override
    @GetMapping(value = "/info")
    public Response<AccountInfoMp> getAccountInfo(@RequestHeader String clientId, @RequestHeader String uid) {
        logger.info("手机客户端[{}]获取账号[{}]信息", clientId, uid);
        return new Response<>(accountAppService.getMpAccountInfo(uid));
    }

    @Override
    @PostMapping(
            value = "/action/modifyNickname",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<Void> modifyAccountInfo(@RequestHeader String clientId, @RequestHeader String uid,
                                            @RequestParam String nickname) {
        logger.info("手机客户端[{}]修改账号[{}]昵称[{}]", clientId, uid, nickname);
        accountAppService.modifyMpAccountInfo(uid, MapUtil.of("nickname", nickname));
        return new Response<>();
    }

    @Override
    @PostMapping(
            value = "/action/modifyGender",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<Void> modifyGender(@RequestHeader String clientId, @RequestHeader String uid,
                                       @RequestParam String gender) {
        logger.info("手机客户端[{}]修改账号[{}]性别[{}]", clientId, uid, gender);
        accountAppService.modifyMpAccountInfo(uid, MapUtil.of("gender", gender));
        return new Response<>();
    }
}
