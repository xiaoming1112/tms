package tyut.service;

import java.util.List;

import tyut.bean.Base;
import tyut.bean.Login;
import tyut.bean.School;
import tyut.bean.Teacher;

public interface ITeacherService {
	public void saveOrUpdate(Teacher teacher) throws Exception;

	public Teacher findById(int id) throws Exception;

	public Teacher findByLogin(Login login) throws Exception;

	public List<Teacher> findBySchool(School school);

	public List<Teacher> findByBase(Base base);

	public List<Teacher> findByStatus(String status);

	public List<Teacher> findAll();

	public List<Teacher> findByName(String name);

	public void deleteById(int id) throws Exception;
}
