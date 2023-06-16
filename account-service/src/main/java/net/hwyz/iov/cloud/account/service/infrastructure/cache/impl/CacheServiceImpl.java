package net.hwyz.iov.cloud.account.service.infrastructure.cache.impl;

import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import net.hwyz.iov.cloud.account.service.domain.contract.enums.CountryRegion;
import net.hwyz.iov.cloud.account.service.infrastructure.cache.CacheService;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.LoginPo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * 缓存服务实现类
 *
 * @author hwyz_leo
 */
@Service
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService {

    final RedisTemplate<String, String> redisTemplate;

    /**
     * Redis Key前缀：登录
     */
    private static final String REDIS_KEY_PREFIX_LOGIN = "account:login:";

    @Override
    public Optional<LoginPo> getMobileLogin(CountryRegion countryRegion, String mobile) {
        String loginDoJson = redisTemplate.opsForValue().get(REDIS_KEY_PREFIX_LOGIN + countryRegion.code + "-" + mobile);
        if (StringUtils.hasText(loginDoJson)) {
            return Optional.of(JSONUtil.toBean(loginDoJson, LoginPo.class));
        }
        return Optional.empty();
    }

    @Override
    public void setMobileLogin(LoginPo loginPo) {
        redisTemplate.opsForValue().set(REDIS_KEY_PREFIX_LOGIN + loginPo.getCountryRegionCode() + "-" + loginPo.getMobile(),
                JSONUtil.parse(loginPo).toJSONString(0));
    }
}
