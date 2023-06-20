package net.hwyz.iov.cloud.account.api.feign.mp;

import net.hwyz.iov.cloud.account.api.contract.AccountInfoMp;
import net.hwyz.iov.cloud.framework.commons.bean.Response;
import net.hwyz.iov.cloud.framework.commons.enums.Gender;

/**
 * 账户相关手机接口
 *
 * @author hwyz_leo
 */
public interface AccountMpApi {

    /**
     * 获取账号信息
     *
     * @param clientId 客户端ID
     * @param uid      账号唯一ID
     * @return 手机账户信息
     */
    Response<AccountInfoMp> getAccountInfo(String clientId, String uid);

    /**
     * 修改昵称
     *
     * @param clientId 客户端ID
     * @param uid      账号唯一ID
     * @param nickname 昵称
     * @return 操作结果
     */
    Response<Void> modifyAccountInfo(String clientId, String uid, String nickname);

    /**
     * 修改性别
     *
     * @param clientId 客户端ID
     * @param uid      账号唯一ID
     * @param gender   性别
     * @return 操作结果
     */
    Response<Void> modifyGender(String clientId, String uid, String gender);

}
