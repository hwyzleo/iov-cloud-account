package net.hwyz.iov.cloud.account.api.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 手机端账户信息
 *
 * @author hwyz_leo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfoMp {

    /**
     * 手机号
     */
    private String mobile;
    /**
     * 昵称
     */
    private String nickname;

}
