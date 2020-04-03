package tyut.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tyut.bean.Base;
import tyut.bean.Login;
import tyut.bean.School;
import tyut.bean.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {
	Teacher findByLogin(Login login);
	List<Teacher> findBySchool(School school);
	List<Teacher> findByBase(Base base);
	List<Teacher> findByNameLike(String name);
	List<Teacher> findByStatus(String status);
}
