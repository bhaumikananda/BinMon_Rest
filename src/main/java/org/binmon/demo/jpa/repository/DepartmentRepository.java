package org.binmon.demo.jpa.repository;

import org.binmon.demo.jpa.domain.Dept;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Dept, String> {

}