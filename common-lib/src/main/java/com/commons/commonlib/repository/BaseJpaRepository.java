package com.commons.commonlib.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseJpaRepository<T, ID> extends JpaRepository<T, ID> {
}
