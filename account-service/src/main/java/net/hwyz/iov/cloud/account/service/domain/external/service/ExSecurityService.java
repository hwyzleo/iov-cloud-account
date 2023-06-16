package net.hwyz.iov.cloud.account.service.domain.external.service;

/**
 * 外部安全服务
 *
 * @author hwyz_leo
 */
public interface ExSecurityService {

    /**
     * 获取手机密钥
     *
     * @param uid      账号唯一ID
     * @param clientId 客户端ID
     * @return 手机密钥
     */
    byte[] getMobileKey(String uid, String clientId);

}
