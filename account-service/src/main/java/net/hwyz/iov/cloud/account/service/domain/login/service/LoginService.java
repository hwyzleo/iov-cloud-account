package net.hwyz.iov.cloud.account.service.domain.login.service;

import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;

/**
 * 登录领域服务接口
 *
 * @author hwyz_leo
 */
public interface LoginService {

    /**
     * 发送手机验证码
     *
     * @param clientId      客户端ID
     * @param countryRegion 国家或地区
     * @param mobile        手机号
     */
    void sendMobileVerifyCode(String clientId, CountryRegion countryRegion, String mobile);

    /**
     * 验证手机验证码
     *
     * @param countryRegion 国家或地区
     * @param mobile        手机号
     * @param verifyCode    验证码
     * @return 验证码是否正确
     */
    boolean verifyMobileVerifyCode(CountryRegion countryRegion, String mobile, String verifyCode);

}
