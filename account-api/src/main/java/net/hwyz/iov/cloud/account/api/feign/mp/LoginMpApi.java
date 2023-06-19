package net.hwyz.iov.cloud.account.api.feign.mp;

import net.hwyz.iov.cloud.account.api.contract.response.LoginMpResponse;
import net.hwyz.iov.cloud.framework.commons.bean.Response;

/**
 * 登录相关手机接口
 *
 * @author hwyz_leo
 */
public interface LoginMpApi {

    /**
     * 发送登录验证码
     *
     * @param clientId          客户端ID
     * @param countryRegionCode 国家或地区代码
     * @param mobile            手机号
     * @return 操作结果
     */
    Response<Void> sendVerifyCode(String clientId, String countryRegionCode, String mobile);

    /**
     * 验证码登录
     *
     * @param clientId          客户端ID
     * @param countryRegionCode 国家或地区代码
     * @param mobile            手机号
     * @param verifyCode        登录验证码
     * @return 手机登录结果
     */
    Response<LoginMpResponse> verifyCodeLogin(String clientId, String countryRegionCode, String mobile, String verifyCode);

}
