package net.hwyz.iov.cloud.account.service.domain.device.repository;

import net.hwyz.iov.cloud.account.service.domain.contract.BaseRepository;
import net.hwyz.iov.cloud.account.service.domain.device.model.DeviceDo;

import java.util.Optional;

/**
 * 设备领域仓库接口
 *
 * @author hwyz_leo
 */
public interface DeviceRepository extends BaseRepository<Long, DeviceDo> {

    /**
     * 获取最新的设备
     *
     * @param deviceId 设备ID
     * @return 设备领域对象
     */
    Optional<DeviceDo> getLastDevice(String deviceId);

}
