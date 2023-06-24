package net.hwyz.iov.cloud.account.service.domain.account.model;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import net.hwyz.iov.cloud.account.service.domain.contract.BaseDo;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import net.hwyz.iov.cloud.framework.commons.enums.Gender;

/**
 * 账号领域对象
 *
 * @author hwyz_leo
 */
@Getter
@SuperBuilder
public class AccountDo extends BaseDo<Long> {

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
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别
     */
    private Gender gender;

    /**
     * 初始化
     */
    public void init() {
        uid = IdUtil.nanoId();
        gender = Gender.UNKNOWN;
        nickname = "用户" + RandomUtil.randomNumbers(8);
        stateInit();
    }

    public void modifyAvatar(String avatar) {
        this.avatar = avatar;
        stateChange();
    }

    public void modifyNickname(String nickname) {
        if (!this.nickname.equals(nickname)) {
            this.nickname = nickname;
            stateChange();
        }
    }

    public void modifyGender(Gender gender) {
        if (!this.gender.equals(gender)) {
            this.gender = gender;
            stateChange();
        }
    }

}
