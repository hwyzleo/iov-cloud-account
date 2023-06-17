package net.hwyz.iov.cloud.account.service.domain.device.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.DeviceType;
import net.hwyz.iov.cloud.account.service.domain.device.model.DeviceDo;
import net.hwyz.iov.cloud.account.service.domain.device.repository.DeviceRepository;
import net.hwyz.iov.cloud.account.service.domain.device.service.DeviceService;
import net.hwyz.iov.cloud.account.service.domain.factory.DeviceFactory;
import org.springframework.stereotype.Service;

/**
 * 设备领域服务接口实现类
 *
 * @author hwyz_leo
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    final DeviceFactory factory;
    final DeviceRepository repository;

    @Override
    public DeviceDo getOrCreate(String deviceId, DeviceType deviceType) {
        return repository.getLastDevice(deviceId).orElseGet(() -> {
            DeviceDo newDeviceDo = factory.build(deviceId, deviceType);
            newDeviceDo.init();
            repository.save(newDeviceDo);
            return newDeviceDo;
        });
    }

    @Override
    public DeviceDo login(String deviceId, DeviceType deviceType, String uid) {
        logger.info("设备[{}:{}]登录用户[{}]", deviceType, deviceId, uid);
        DeviceDo deviceDo = getOrCreate(deviceId, deviceType);
        deviceDo.login(uid);
        repository.save(deviceDo);
        return deviceDo;
    }
}
