package net.hwyz.iov.cloud.account.service.domain.external.service;

import net.hwyz.iov.cloud.account.service.infrastructure.external.ExObjectServiceFallbackFactory;
import net.hwyz.iov.cloud.oss.api.contract.PreSignedUrl;
import net.hwyz.iov.cloud.oss.api.contract.enums.ObjectAccessPermission;
import net.hwyz.iov.cloud.oss.api.contract.request.GeneratePreSignedUrlRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 外部对象服务
 *
 * @author hwyz_leo
 */
@FeignClient(name = "oss-service", path = "/service/object", fallbackFactory = ExObjectServiceFallbackFactory.class)
public interface ExObjectService {

    /**
     * 生成预签名地址
     *
     * @param request 生成预签名地址请求
     * @return 预签名地址
     */
    @PostMapping("/action/generatePreSignedUrl")
    PreSignedUrl generatePreSignedUrl(GeneratePreSignedUrlRequest request);

}
