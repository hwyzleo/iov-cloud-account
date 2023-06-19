package net.hwyz.iov.cloud.account.service.infrastructure.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import lombok.experimental.SuperBuilder;
import lombok.*;

/**
 * <p>
 * 客户端数据 数据对象
 * </p>
 *
 * @author hwyz_leo
 * @since 2023-06-17
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_client")
public class ClientPo extends BasePo {

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
     * 客户端类型
     */
    @TableField("client_type")
    private String clientType;

    /**
     * 设备厂商
     */
    @TableField("oem")
    private String oem;

    /**
     * 操作系统版本
     */
    @TableField("os_version")
    private String osVersion;

    /**
     * 应用版本
     */
    @TableField("app_version")
    private String appVersion;

    /**
     * IP地址
     */
    @TableField("ip")
    private String ip;

    /**
     * 最后登录时间
     */
    @TableField("login_time")
    private Date loginTime;
}
