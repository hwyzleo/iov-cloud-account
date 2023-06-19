package net.hwyz.iov.cloud.account.service.domain.client.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import net.hwyz.iov.cloud.account.service.domain.contract.BaseDo;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.ClientOperation;
import net.hwyz.iov.cloud.framework.commons.enums.ClientType;

import java.util.Date;

/**
 * 客户端领域对象
 *
 * @author hwyz_leo
 */
@Getter
@SuperBuilder
public class ClientDo extends BaseDo<Long> {

    /**
     * 账号唯一ID
     */
    private String uid;
    /**
     * 客户端ID
     */
    private String clientId;
    /**
     * 客户端类型
     */
    private ClientType clientType;
    /**
     * 最后登录时间
     */
    private Date loginTime;

    /**
     * 初始化
     */
    public void init() {
        stateInit();
    }

    /**
     * 检查客户端操作
     *
     * @param operation 客户端操作
     */
    public void checkOperation(ClientOperation operation) {
        // TODO 可增加策略动态限制
        // 现在先不限制
    }

    /**
     * 客户端登录
     *
     * @param uid 账号唯一ID
     */
    public void login(String uid) {
        this.uid = uid;
        this.loginTime = new Date();
        stateChange();
    }

}
