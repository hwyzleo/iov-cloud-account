package net.hwyz.iov.cloud.account.service.domain.token.model;

import cn.hutool.core.util.IdUtil;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import net.hwyz.iov.cloud.account.service.domain.contract.BaseDo;
import net.hwyz.iov.cloud.framework.commons.enums.ClientType;

import java.util.Date;

/**
 * 令牌领域对象
 *
 * @author hwyz_leo
 */
@Getter
@SuperBuilder
public class TokenDo extends BaseDo<Long> {

    /**
     * 账号唯一ID
     */
    private String uid;
    /**
     * 客户端类型
     */
    private ClientType clientType;
    /**
     * 发行时间
     */
    private Date issueTime;
    /**
     * 访问令牌
     */
    private String accessToken;
    /**
     * 访问令牌过期时间
     */
    private Date accessTokenExpires;
    /**
     * 刷新令牌
     */
    private String refreshToken;
    /**
     * 刷新令牌过期时间
     */
    private Date refreshTokenExpires;
    /**
     * 客户端ID
     */
    private String clientId;
    /**
     * 车架号
     */
    private String vin;

    /**
     * 初始化
     */
    public void init() {
        stateInit();
        issueTime = new Date();
        accessToken = IdUtil.nanoId(64);
        accessTokenExpires = new Date(issueTime.getTime() + 24 * 60 * 60 * 1000);
        refreshToken = IdUtil.nanoId(64);
        refreshTokenExpires = new Date(issueTime.getTime() + 30L * 24 * 60 * 60 * 1000);
    }

}
