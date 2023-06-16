package net.hwyz.iov.cloud.account.api.contract.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * 登录响应
 *
 * @author hwyz_leo
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    /**
     * 访问令牌
     */
    private String token;
    /**
     * 访问令牌过期时间
     */
    private Date tokenExpires;
    /**
     * 刷新令牌
     */
    private String refreshToken;
    /**
     * 刷新令牌过期时间
     */
    private Date refreshTokenExpires;

}
