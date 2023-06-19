package net.hwyz.iov.cloud.account.api.feign.mp;

import net.hwyz.iov.cloud.account.api.contract.AccountInfoMp;
import net.hwyz.iov.cloud.framework.commons.bean.Response;

/**
 * 账户相关手机接口
 *
 * @author hwyz_leo
 */
public interface AccountMpApi {

    /**
     * 获取账户信息
     *
     * @param uid 账户唯一ID
     * @return 手机账户信息
     */
    Response<AccountInfoMp> getAccountInfo(String uid);

}
