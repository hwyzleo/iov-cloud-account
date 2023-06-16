package net.hwyz.iov.cloud.account.service.infrastructure.repository;

import net.hwyz.iov.cloud.account.service.domain.contract.BaseRepository;

import java.util.Optional;

/**
 * 领域仓库抽象类
 *
 * @param <ID> 主键
 * @param <DomainObj> 领域对象
 */
public abstract class AbstractRepository<ID, DomainObj> implements BaseRepository<ID, DomainObj> {
    public abstract Optional<DomainObj> getById(ID id);

    public abstract boolean save(DomainObj obj);

}
