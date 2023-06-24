package net.hwyz.iov.cloud.account.api.feign.mp;

import net.hwyz.iov.cloud.account.api.contract.AccountInfoMp;
import net.hwyz.iov.cloud.framework.commons.bean.Response;
import net.hwyz.iov.cloud.oss.api.contract.PreSignedUrl;

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
     * 生成头像上传地址
     *
     * @param clientId 客户端ID
     * @param uid      账号唯一ID
     * @return 头像上传地址
     */
    Response<PreSignedUrl> generateAvatarUrl(String clientId, String uid);

    /**
     * 修改头像
     *
     * @param clientId 客户端ID
     * @param uid      账号唯一ID
     * @param avatar   头像
     * @return 操作结果
     */
    Response<Void> modifyAvatar(String clientId, String uid, String avatar);

    /**
     * 修改昵称
     *
     * @param clientId 客户端ID
     * @param uid      账号唯一ID
     * @param nickname 昵称
     * @return 操作结果
     */
    Response<Void> modifyNickname(String clientId, String uid, String nickname);

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
