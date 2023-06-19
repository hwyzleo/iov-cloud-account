package net.hwyz.iov.cloud.account.service.domain.client.service;

import net.hwyz.iov.cloud.account.service.domain.client.model.ClientDo;
import net.hwyz.iov.cloud.framework.commons.enums.ClientType;

/**
 * 客户端领域服务接口
 *
 * @author hwyz_leo
 */
public interface ClientService {

    /**
     * 获取或新建客户端
     *
     * @param clientId   客户端ID
     * @param clientType 客户端类型
     * @return 客户端领域对象
     */
    ClientDo getOrCreate(String clientId, ClientType clientType);

    /**
     * 客户端登录
     *
     * @param clientId   客户端ID
     * @param clientType 客户端类型
     * @param uid        账号唯一ID
     * @return 客户端领域对象
     */
    ClientDo login(String clientId, ClientType clientType, String uid);

}
