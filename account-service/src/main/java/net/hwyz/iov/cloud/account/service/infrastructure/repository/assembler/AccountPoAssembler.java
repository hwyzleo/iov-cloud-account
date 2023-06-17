package net.hwyz.iov.cloud.account.service.infrastructure.repository.assembler;

import net.hwyz.iov.cloud.account.service.domain.account.model.AccountDo;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.AccountPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 账号数据对象转换类
 *
 * @author hwyz_leo
 */
@Mapper
public interface AccountPoAssembler {

    AccountPoAssembler INSTANCE = Mappers.getMapper(AccountPoAssembler.class);

    /**
     * 数据对象转领域对象
     *
     * @param accountPo 数据对象
     * @return 领域对象
     */
    @Mappings({})
    AccountDo toDo(AccountPo accountPo);

    /**
     * 领域对象转数据对象
     *
     * @param accountDo 领域对象
     * @return 数据对象
     */
    @Mappings({
            @Mapping(target = "countryRegionCode", source = "countryRegion.code")
    })
    AccountPo fromDo(AccountDo accountDo);

}
