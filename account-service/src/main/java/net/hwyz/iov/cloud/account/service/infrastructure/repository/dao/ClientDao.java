package net.hwyz.iov.cloud.account.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.ClientPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 客户端数据 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2023-06-17
 */
@Mapper
public interface ClientDao extends BaseDao<ClientPo, Long> {

    /**
     * 根据数据对象获取对应最新的数据对象
     *
     * @param clientPo 数据对象
     * @return 数据对象
     */
    ClientPo selectLastPoByExample(ClientPo clientPo);

}
