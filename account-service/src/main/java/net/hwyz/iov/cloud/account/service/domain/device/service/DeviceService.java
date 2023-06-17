package net.hwyz.iov.cloud.account.service.domain.device.service;

import net.hwyz.iov.cloud.account.service.domain.contract.enums.DeviceType;
import net.hwyz.iov.cloud.account.service.domain.device.model.DeviceDo;

/**
 * 设备领域服务接口
 *
 * @author hwyz_leo
 */
public interface DeviceService {

    /**
     * 获取或新建设备
     *
     * @param deviceId   设备ID
     * @param deviceType 设备类型
     * @return 设备领域对象
     */
    DeviceDo getOrCreate(String deviceId, DeviceType deviceType);

    /**
     * 设备登录
     *
     * @param deviceId   设备ID
     * @param deviceType 设备类型
     * @param uid        账号唯一ID
     * @return 设备领域对象
     */
    DeviceDo login(String deviceId, DeviceType deviceType, String uid);

}
