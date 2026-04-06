package org.app.service;

import org.app.dao.OperatorDao;
import org.app.model.Operator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService {
	private final OperatorDao operatorDao;

	public OperatorService(OperatorDao operatorDao) {
		this.operatorDao = operatorDao;
	}

	public Operator create(String name) {
		Operator operator = new Operator();
		operator.setName(name);
		return operatorDao.save(operator);
	}

	public Operator getById(Long id) {
		Operator operator = operatorDao.findById(id)
				.orElseThrow(() -> new RuntimeException("Operator not found"));

		operator.setName("operator" + operator.getId());
		return operator;
	}

	public List<Operator> getAll() {
		return operatorDao.findAll();
	}
}
