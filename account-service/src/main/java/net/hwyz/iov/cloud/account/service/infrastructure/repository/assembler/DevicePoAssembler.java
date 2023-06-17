package net.hwyz.iov.cloud.account.service.infrastructure.repository.assembler;

import net.hwyz.iov.cloud.account.service.domain.device.model.DeviceDo;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.DevicePo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 设备数据对象转换类
 *
 * @author hwyz_leo
 */
@Mapper
public interface DevicePoAssembler {

    DevicePoAssembler INSTANCE = Mappers.getMapper(DevicePoAssembler.class);

    /**
     * 领域对象转数据对象
     *
     * @param deviceDo 领域对象
     * @return 数据对象
     */
    @Mappings({})
    DevicePo fromDo(DeviceDo deviceDo);

    /**
     * 数据对象转领域对象
     *
     * @param devicePo 数据对象
     * @return 领域对象
     */
    @Mappings({})
    DeviceDo toDo(DevicePo devicePo);

}
