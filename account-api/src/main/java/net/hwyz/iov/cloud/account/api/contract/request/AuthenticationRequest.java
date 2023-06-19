package net.hwyz.iov.cloud.account.api.contract.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 身份认证请求
 *
 * @author hwyz_leo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {

    /**
     * 令牌
     */
    @NotEmpty(message = "令牌不允许为空")
    private String token;
    /**
     * 客户端ID
     */
    @NotEmpty(message = "客户端ID不允许为空")
    private String clientId;

}
