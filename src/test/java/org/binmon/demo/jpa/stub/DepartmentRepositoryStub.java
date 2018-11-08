package org.binmon.demo.jpa.stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.binmon.demo.jpa.domain.Dept;
import org.binmon.demo.jpa.repository.DepartmentRepository;

public class DepartmentRepositoryStub implements DepartmentRepository {

	@Override
	public <S extends Dept> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Dept> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Dept> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Dept> findAll() {
		List<Dept> departments = new ArrayList<Dept>(Arrays.asList(
				new Dept("1", "Maths", "Bhaumik"),
				new Dept("2", "Physics", "Sen"),
				new Dept("Hi", "Physics", "Sen"),
				new Dept("3", "French", "Mance"),
				new Dept("3", "Russian", "Vodskova")
			));
		return departments;
	}

	@Override
	public Iterable<Dept> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}
 
	@Override
	public void delete(Dept entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Dept> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
