package net.hwyz.iov.cloud.account.service.domain.token.model;

import cn.hutool.core.util.IdUtil;
import cn.hutool.jwt.JWTUtil;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import net.hwyz.iov.cloud.account.service.domain.contract.BaseDo;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.TokenType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 令牌领域对象
 *
 * @author hwyz_leo
 */
@Getter
@SuperBuilder
public class TokenDo extends BaseDo {

    /**
     * 账号唯一ID
     */
    private String uid;
    /**
     * 令牌类型
     */
    private TokenType tokenType;
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
     *
     * @param key 密钥
     */
    public void init(byte[] key) {
        stateInit();
        issueTime = new Date();
        accessToken = generateToken(key);
        accessTokenExpires = new Date(issueTime.getTime() + 24 * 60 * 60 * 1000);
        refreshToken = IdUtil.nanoId(32);
        refreshTokenExpires = new Date(issueTime.getTime() + 30L * 24 * 60 * 60 * 1000);
    }

    /**
     * 生成令牌
     *
     * @param key 密钥
     * @return 令牌
     */
    private String generateToken(byte[] key) {
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        Map<String, Object> payload = new HashMap<>();
        payload.put("issueTime", issueTime.getTime());
        return JWTUtil.createToken(header, payload, key);
    }

}
