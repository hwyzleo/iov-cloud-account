package net.hwyz.iov.cloud.account.service.infrastructure.external;

import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.account.service.domain.external.service.ExSecurityService;
import org.springframework.stereotype.Service;

/**
 * 外部安全服务实现类
 *
 * @author hwyz_leo
 */
@Slf4j
@Service
public class ExSecurityServiceImpl implements ExSecurityService {
    @Override
    public byte[] getMobileKey(String uid, String clientId) {
        logger.info("获取用户[{}]手机[{}]密钥", uid, clientId);
        return new byte[]{0, 0, 0, 0, 0, 0, 0, 0};
    }
}
