package net.hwyz.iov.cloud.account.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.TokenPo;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 令牌数据 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2023-06-16
 */
@Mapper
public interface TokenDao extends BaseDao<TokenPo, Long> {

}
