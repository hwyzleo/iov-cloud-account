package net.hwyz.iov.cloud.account.service.application.service;

import lombok.RequiredArgsConstructor;
import net.hwyz.iov.cloud.account.api.contract.AccountInfoMp;
import net.hwyz.iov.cloud.account.service.domain.account.model.AccountDo;
import net.hwyz.iov.cloud.account.service.domain.account.repository.AccountRepository;
import net.hwyz.iov.cloud.account.service.domain.account.service.AccountService;
import net.hwyz.iov.cloud.account.service.infrastructure.exception.AccountNotExistException;
import net.hwyz.iov.cloud.framework.commons.enums.Gender;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 账号应用服务类
 *
 * @author hwyz_leo
 */
@Service
@RequiredArgsConstructor
public class AccountAppService {

    final AccountService accountService;
    final AccountRepository accountRepository;

    /**
     * 获取手机端账号信息
     *
     * @param uid 账号唯一ID
     * @return 手机端账号信息
     */
    public AccountInfoMp getMpAccountInfo(String uid) {
        return accountService.get(uid).map(accountDo -> AccountInfoMp.builder()
                .mobile(accountDo.getMobile())
                .nickname(accountDo.getNickname())
                .gender(accountDo.getGender().name())
                .build()).orElse(null);
    }

    /**
     * 修改手机端账号信息
     *
     * @param uid     账号唯一ID
     * @param infoMap 信息Map
     */
    public void modifyMpAccountInfo(String uid, Map<String, String> infoMap) {
        AccountDo accountDo = accountService.get(uid).orElseThrow(() -> new AccountNotExistException(uid));
        if (infoMap.containsKey("nickname")) {
            accountDo.modifyNickname(infoMap.get("nickname"));
        }
        if (infoMap.containsKey("gender")) {
            accountDo.modifyGender(Gender.valueOf(infoMap.get("gender")));
        }
        accountRepository.save(accountDo);
    }

}
