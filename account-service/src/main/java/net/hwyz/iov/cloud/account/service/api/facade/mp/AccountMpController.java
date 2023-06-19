package net.hwyz.iov.cloud.account.service.api.facade.mp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.account.api.contract.AccountInfoMp;
import net.hwyz.iov.cloud.account.api.feign.mp.AccountMpApi;
import net.hwyz.iov.cloud.account.service.domain.account.service.AccountService;
import net.hwyz.iov.cloud.framework.commons.bean.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    final AccountService accountService;

    @Override
    @GetMapping(value = "/info")
    public Response<AccountInfoMp> getAccountInfo(@RequestHeader String uid) {
        Response<AccountInfoMp> response = new Response<>();
        accountService.get(uid).ifPresent(accountDo -> response.setData(AccountInfoMp.builder()
                .mobile(accountDo.getMobile())
                .nickname(accountDo.getNickname())
                .build()));
        return response;
    }

}
