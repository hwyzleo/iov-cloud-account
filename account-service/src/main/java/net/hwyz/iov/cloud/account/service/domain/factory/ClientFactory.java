package net.hwyz.iov.cloud.account.service.domain.factory;

import net.hwyz.iov.cloud.account.service.domain.client.model.ClientDo;
import net.hwyz.iov.cloud.framework.commons.enums.ClientType;
import org.springframework.stereotype.Component;

/**
 * 客户端领域工厂类
 *
 * @author hwyz_leo
 */
@Component
public class ClientFactory {

    /**
     * 基于客户端ID创建
     *
     * @param clientId   客户端ID
     * @param clientType 客户端类型
     * @return 领域对象
     */
    public ClientDo build(String clientId, ClientType clientType) {
        return ClientDo.builder()
                .clientId(clientId)
                .clientType(clientType)
                .build();
    }

}
