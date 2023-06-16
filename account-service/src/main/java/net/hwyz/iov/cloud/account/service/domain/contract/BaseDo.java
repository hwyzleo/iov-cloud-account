package net.hwyz.iov.cloud.account.service.domain.contract;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.DoState;

/**
 * 基础领域对象
 *
 * @author hwyz_leo
 */
@Getter
@SuperBuilder
public class BaseDo {

    /**
     * 领域对象状态
     */
    private DoState state;

    /**
     * 状态初始化
     */
    protected void stateInit() {
        state = DoState.NEW;
    }

    /**
     * 被读取时状态
     */
    public void stateLoad() {
        state = DoState.UNCHANGED;
    }

    /**
     * 状态改变
     */
    protected void stateChange() {
        if (state == DoState.UNCHANGED) {
            state = DoState.CHANGED;
        }
    }

}
