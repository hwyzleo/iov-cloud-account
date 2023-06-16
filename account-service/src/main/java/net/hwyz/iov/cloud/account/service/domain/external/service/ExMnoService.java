package net.hwyz.iov.cloud.account.service.domain.external.service;

import java.util.List;

/**
 * 外部通讯服务
 *
 * @author hwyz_leo
 */
public interface ExMnoService {

    /**
     * 发送短信
     *
     * @param templateId        短信模板ID
     * @param countryRegionCode 国家或地区代码
     * @param mobile            手机号
     * @param parameters        短信内容参数
     */
    void sendSms(String templateId, String countryRegionCode, String mobile, List<String> parameters);

}
