package org.app.dao;

import org.app.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorDao extends JpaRepository<Operator, Long> {
}
