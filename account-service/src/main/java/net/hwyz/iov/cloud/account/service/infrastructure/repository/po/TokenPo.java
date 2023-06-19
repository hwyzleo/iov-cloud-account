package net.hwyz.iov.cloud.account.service.infrastructure.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.experimental.SuperBuilder;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.BasePo;
import lombok.*;

/**
 * <p>
 * 令牌数据 数据对象
 * </p>
 *
 * @author hwyz_leo
 * @since 2023-06-16
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_token")
public class TokenPo extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号唯一ID
     */
    @TableField("uid")
    private String uid;

    /**
     * 客户端ID
     */
    @TableField("client_id")
    private String clientId;

    /**
     * 车架号
     */
    @TableField("vin")
    private String vin;

    /**
     * 权限范围
     */
    @TableField("scope")
    private String scope;

    /**
     * 客户端类型
     */
    @TableField("client_type")
    private String clientType;

    /**
     * 发行时间
     */
    @TableField("issue_time")
    private Date issueTime;

    /**
     * 访问令牌
     */
    @TableField("access_token")
    private String accessToken;

    /**
     * 访问令牌过期时间
     */
    @TableField("access_token_expires")
    private Date accessTokenExpires;

    /**
     * 刷新令牌
     */
    @TableField("refresh_token")
    private String refreshToken;

    /**
     * 刷新令牌过期时间
     */
    @TableField("refresh_token_expires")
    private Date refreshTokenExpires;
}
