package net.hwyz.iov.cloud.account.service.domain.client.repository;

import net.hwyz.iov.cloud.account.service.domain.contract.BaseRepository;
import net.hwyz.iov.cloud.account.service.domain.client.model.ClientDo;

import java.util.Optional;

/**
 * 客户端领域仓库接口
 *
 * @author hwyz_leo
 */
public interface ClientRepository extends BaseRepository<Long, ClientDo> {

    /**
     * 获取最新的客户端
     *
     * @param clientId 客户端ID
     * @return 客户端领域对象
     */
    Optional<ClientDo> getLastClient(String clientId);

}
