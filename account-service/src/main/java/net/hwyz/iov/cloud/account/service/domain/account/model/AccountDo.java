package net.hwyz.iov.cloud.account.service.domain.account.model;

import cn.hutool.core.util.IdUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import net.hwyz.iov.cloud.account.service.domain.contract.BaseDo;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;

/**
 * 账号领域对象
 *
 * @author hwyz_leo
 */
@Getter
@SuperBuilder
public class AccountDo extends BaseDo {

    /**
     * 账号唯一ID
     */
    private String uid;
    /**
     * 国家或地区代码
     */
    private CountryRegion countryRegion;
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 初始化
     */
    public void init() {
        uid = IdUtil.nanoId();
        stateInit();
    }

}
