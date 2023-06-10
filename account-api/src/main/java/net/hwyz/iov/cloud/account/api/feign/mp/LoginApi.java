package net.hwyz.iov.cloud.account.api.feign.mp;

import net.hwyz.iov.cloud.account.api.contract.response.LoginResponse;
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
     * @param mobile 手机号
     * @return 操作结果
     */
    Response<Void> sendVerifyCode(String mobile);

    /**
     * 验证码登录
     *
     * @param mobile     手机号
     * @param verifyCode 登录验证码
     * @return 登录结果
     */
    Response<LoginResponse> verifyCodeLogin(String mobile, String verifyCode);

}
