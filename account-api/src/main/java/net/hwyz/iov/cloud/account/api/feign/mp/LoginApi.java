package net.hwyz.iov.cloud.account.api.feign.mp;

import net.hwyz.iov.cloud.account.api.contract.response.MobileLoginResponse;
import net.hwyz.iov.cloud.framework.commons.bean.Response;

/**
 * 登录相关接口
 *
 * @author hwyz_leo
 */
public interface LoginApi {

    /**
     * 发送登录验证码
     *
     * @param countryRegionCode 国家或地区代码
     * @param mobile            手机号
     * @return 操作结果
     */
    Response<Void> sendVerifyCode(String countryRegionCode, String mobile);

    /**
     * 验证码登录
     *
     * @param countryRegionCode 国家或地区代码
     * @param mobile            手机号
     * @param deviceId          手机设备ID
     * @param verifyCode        登录验证码
     * @return 手机登录结果
     */
    Response<MobileLoginResponse> verifyCodeLogin(String countryRegionCode, String mobile, String deviceId, String verifyCode);

}
