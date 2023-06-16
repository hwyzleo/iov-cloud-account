package net.hwyz.iov.cloud.account.service.infrastructure.repository.assembler;

import net.hwyz.iov.cloud.account.service.domain.login.model.LoginDo;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.LoginPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 登录数据对象转换类
 *
 * @author hwyz_leo
 */
@Mapper
public interface LoginPoAssembler {

    LoginPoAssembler INSTANCE = Mappers.getMapper(LoginPoAssembler.class);

    /**
     * 领域对象转数据对象
     *
     * @param loginDo 领域对象
     * @return 数据对象
     */
    @Mappings({
            @Mapping(target = "countryRegionCode", source = "countryRegion.code")
    })
    LoginPo fromDo(LoginDo loginDo);

    /**
     * 数据对象转领域对象
     *
     * @param loginPo 数据对象
     * @return 领域对象
     */
    @Mappings({
            @Mapping(target = "countryRegion", expression = "java(net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion.valOf(loginPo.getCountryRegionCode()))")
    })
    LoginDo toDo(LoginPo loginPo);

}
