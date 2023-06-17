package net.hwyz.iov.cloud.account.service.infrastructure.repository;

import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.hwyz.iov.cloud.account.service.domain.device.model.DeviceDo;
import net.hwyz.iov.cloud.account.service.domain.device.repository.DeviceRepository;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.assembler.DevicePoAssembler;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.dao.DeviceDao;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.DevicePo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 设备领域仓库接口实现类
 *
 * @author hwyz_leo
 */
@Log4j2
@Repository
@RequiredArgsConstructor
public class DeviceRepositoryImpl extends AbstractRepository<Long, DeviceDo> implements DeviceRepository {

    final DeviceDao deviceDao;

    @Override
    public Optional<DeviceDo> getLastDevice(String deviceId) {
        DevicePo devicePo = deviceDao.selectLastPoByExample(DevicePo.builder().deviceId(deviceId).build());
        if (devicePo != null) {
            DeviceDo deviceDo = DevicePoAssembler.INSTANCE.toDo(devicePo);
            deviceDo.stateLoad();
            return Optional.of(deviceDo);
        }
        return Optional.empty();
    }

    @Override
    public Optional<DeviceDo> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean save(DeviceDo deviceDo) {
        if (logger.isDebugEnabled()) {
            logger.debug("保存设备领域对象[{}]", JSONUtil.parse(deviceDo).toJSONString(0));
        }
        switch (deviceDo.getState()) {
            case NEW -> deviceDao.insertPo(DevicePoAssembler.INSTANCE.fromDo(deviceDo));
            case CHANGED -> deviceDao.updatePo(DevicePoAssembler.INSTANCE.fromDo(deviceDo));
            default -> {
                return false;
            }
        }
        return true;
    }

}
