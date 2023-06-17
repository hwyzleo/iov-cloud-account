package net.hwyz.iov.cloud.account.service.domain.factory;

import net.hwyz.iov.cloud.account.service.domain.contract.enums.DeviceType;
import net.hwyz.iov.cloud.account.service.domain.device.model.DeviceDo;
import org.springframework.stereotype.Component;

/**
 * 设备领域工厂类
 *
 * @author hwyz_leo
 */
@Component
public class DeviceFactory {

    /**
     * 基于设备ID创建
     *
     * @param deviceId   设备ID
     * @param deviceType 设备类型
     * @return 领域对象
     */
    public DeviceDo build(String deviceId, DeviceType deviceType) {
        return DeviceDo.builder()
                .deviceId(deviceId)
                .deviceType(deviceType)
                .build();
    }

}
