package net.hwyz.iov.cloud.account.api.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户身份
 *
 * @author hwyz_leo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserIdentity {

    /**
     * 账号唯一ID
     */
    private String uid;

}
