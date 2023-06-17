package net.hwyz.iov.cloud.account.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.DevicePo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 设备数据 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2023-06-17
 */
@Mapper
public interface DeviceDao extends BaseDao<DevicePo, Long> {

    /**
     * 根据数据对象获取对应最新的数据对象
     *
     * @param devicePo 数据对象
     * @return 数据对象
     */
    DevicePo selectLastPoByExample(DevicePo devicePo);

}
