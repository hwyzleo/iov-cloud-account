package net.hwyz.iov.cloud.account.service.domain.login.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import net.hwyz.iov.cloud.account.service.domain.contract.BaseDo;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 登录领域对象
 *
 * @author hwyz_leo
 */
@Getter
@SuperBuilder
public class LoginDo extends BaseDo<Long> {

    /**
     * 国家或地区代码
     */
    private CountryRegion countryRegion;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 验证码
     */
    private String verifyCode;
    /**
     * 验证次数
     */
    private int verifyCount;
    /**
     * 验证上限
     */
    private static final int VERIFY_LIMIT = 2;
    /**
     * 发送时间
     */
    private Date sendTime;
    /**
     * 过期时间
     */
    private Date expirationTime;

    /**
     * 初始化
     */
    public void init() {
        stateInit();
    }

    /**
     * 是否是手机登录
     *
     * @return 是否是手机登录
     */
    private boolean isMobile() {
        return countryRegion != null && StringUtils.hasText(mobile);
    }

    /**
     * 手机发送是否锁定
     *
     * @return 是否锁定
     */
    public boolean isMobileLock() {
        // TODO 可以考虑其他风控机制
        // TODO 可以增加策略入参来提供更多锁定条件
        return isMobile() && verifyCode != null && sendTime != null &&
                (System.currentTimeMillis() - sendTime.getTime()) < 60000;
    }

    /**
     * 生成验证码
     *
     * @return 验证码
     */
    public String generateVerifyCode() {
        if (isMobile()) {
            // TODO 生成6位随机数字
            verifyCode = "111111";
            return verifyCode;
        }
        return verifyCode;
    }

    /**
     * 验证码已发送
     */
    public void sendVerifyCode() {
        sendTime = new Date();
        if (isMobile()) {
            // TODO 可通过策略加入更多情况
            expirationTime = new Date(sendTime.getTime() + 3 * 60 * 60 * 1000);
        }
        stateChange();
    }

    /**
     * 验证码是否已发送
     *
     * @return 验证码是否已发送
     */
    private boolean isVerifyCodeSent() {
        return sendTime != null;
    }

    /**
     * 验证验证码
     *
     * @param verifyCode 验证码
     * @return 验证码是否正确
     */
    public boolean verifyCode(String verifyCode) {
        if (!isVerifyCodeSent()) {
            return false;
        }
        if (expirationTime.before(new Date())) {
            reset();
            return false;
        }
        if (verifyCount > VERIFY_LIMIT) {
            reset();
            return false;
        }
        if (!this.verifyCode.equals(verifyCode)) {
            verifyCount++;
            stateChange();
            return false;
        }
        reset();
        return true;
    }

    /**
     * 重置登录状态
     */
    private void reset() {
        verifyCode = null;
        sendTime = null;
        expirationTime = null;
        stateChange();
    }

}
