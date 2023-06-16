package net.hwyz.iov.cloud.account.api.contract.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * 手机端登录响应
 *
 * @author hwyz_leo
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class MobileLoginResponse extends LoginResponse{

    /**
     * 手机号
     */
    private String mobile;

}
