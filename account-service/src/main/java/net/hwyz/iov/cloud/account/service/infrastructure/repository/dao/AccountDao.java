package net.hwyz.iov.cloud.account.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.account.service.infrastructure.repository.po.AccountPo;
import net.hwyz.iov.cloud.account.service.infrastructure.repository.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 账号数据 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2023-06-15
 */
@Mapper
public interface AccountDao extends BaseDao<AccountPo, Long> {

}
