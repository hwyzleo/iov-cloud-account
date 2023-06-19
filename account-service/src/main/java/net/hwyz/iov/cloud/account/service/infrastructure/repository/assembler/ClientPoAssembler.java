package net.hwyz.iov.cloud.account.service.infrastructure.repository.assembler;

import net.hwyz.iov.cloud.account.service.domain.client.model.ClientDo;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.ClientPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 客户端数据对象转换类
 *
 * @author hwyz_leo
 */
@Mapper
public interface ClientPoAssembler {

    ClientPoAssembler INSTANCE = Mappers.getMapper(ClientPoAssembler.class);

    /**
     * 领域对象转数据对象
     *
     * @param clientDo 领域对象
     * @return 数据对象
     */
    @Mappings({})
    ClientPo fromDo(ClientDo clientDo);

    /**
     * 数据对象转领域对象
     *
     * @param clientPo 数据对象
     * @return 领域对象
     */
    @Mappings({})
    ClientDo toDo(ClientPo clientPo);

}
