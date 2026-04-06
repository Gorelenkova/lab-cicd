package org.app.web;

import org.app.dao.OperatorDao;
import org.app.model.Operator;
import org.app.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operators")
public class OperatorController {
	@Autowired
	OperatorService operatorService;

	@PostMapping
	public Operator create(@RequestParam String name) {
		return operatorService.create(name);
	}
	@GetMapping("/{id}")
	public Operator getById(@PathVariable Long id) {
		return operatorService.getById(id);
	}
	@GetMapping
	public List<Operator> getAll() {
		return operatorService.getAll();
	}
}
