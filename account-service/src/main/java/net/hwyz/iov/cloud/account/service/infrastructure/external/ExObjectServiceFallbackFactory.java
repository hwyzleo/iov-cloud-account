package net.hwyz.iov.cloud.account.service.infrastructure.external;

import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.account.service.domain.external.service.ExObjectService;
import net.hwyz.iov.cloud.oss.api.contract.PreSignedUrl;
import net.hwyz.iov.cloud.oss.api.contract.enums.ObjectAccessPermission;
import net.hwyz.iov.cloud.oss.api.contract.request.GeneratePreSignedUrlRequest;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Service;

/**
 * 外部对象服务回退处理
 *
 * @author hwyz_leo
 */
@Slf4j
@Service
public class ExObjectServiceFallbackFactory implements FallbackFactory<ExObjectService> {

    @Override
    public ExObjectService create(Throwable cause) {
        return new ExObjectService() {

            @Override
            public PreSignedUrl generatePreSignedUrl(GeneratePreSignedUrlRequest request) {
                if (logger.isDebugEnabled()) {
                    logger.warn("生成预签名地址异常", cause);
                } else {
                    logger.warn("生成预签名地址异常:[{}]", cause.getMessage());
                }
                return null;
            }

        };
    }

}
