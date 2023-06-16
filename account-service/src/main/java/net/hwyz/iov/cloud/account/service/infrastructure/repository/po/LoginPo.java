package net.hwyz.iov.cloud.account.service.infrastructure.repository.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 登录数据对象
 *
 * @author hwyz_leo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginPo {

    /**
     * 国家或地区代码
     */
    private String countryRegionCode;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 验证码
     */
    private String verifyCode;
    /**
     * 验证次数
     */
    private Integer verifyCount;
    /**
     * 发送时间
     */
    private Date sendTime;
    /**
     * 过期时间
     */
    private Date expirationTime;

}
