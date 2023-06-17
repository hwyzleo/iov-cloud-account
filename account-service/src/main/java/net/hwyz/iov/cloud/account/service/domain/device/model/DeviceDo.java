package net.hwyz.iov.cloud.account.service.domain.device.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import net.hwyz.iov.cloud.account.service.domain.contract.BaseDo;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.DeviceOperation;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.DeviceType;

import java.util.Date;

/**
 * 设备领域对象
 *
 * @author hwyz_leo
 */
@Getter
@SuperBuilder
public class DeviceDo extends BaseDo<Long> {

    /**
     * 账号唯一ID
     */
    private String uid;
    /**
     * 设备ID
     */
    private String deviceId;
    /**
     * 设备类型
     */
    private DeviceType deviceType;
    /**
     * 最后登录时间
     */
    private Date loginTime;

    /**
     * 初始化
     */
    public void init() {
        stateInit();
    }

    /**
     * 检查设备操作
     *
     * @param operation 设备操作
     */
    public void checkOperation(DeviceOperation operation) {
        // TODO 可增加策略动态限制
        // 现在先不限制
    }

    /**
     * 设备登录
     *
     * @param uid 账号唯一ID
     */
    public void login(String uid) {
        this.uid = uid;
        this.loginTime = new Date();
        stateChange();
    }

}
