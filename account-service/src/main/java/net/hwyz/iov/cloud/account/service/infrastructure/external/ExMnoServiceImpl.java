package net.hwyz.iov.cloud.account.service.infrastructure.external;

import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.account.service.domain.external.service.ExMnoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 外部通讯服务实现类
 *
 * @author hwyz_leo
 */
@Slf4j
@Service
public class ExMnoServiceImpl implements ExMnoService {

    @Override
    public void sendSms(String templateId, String countryRegionCode, String mobile, List<String> parameters) {
        logger.info("向手机[{}:{}]按短信模板[{}]发送", countryRegionCode, mobile, templateId);
    }

}
