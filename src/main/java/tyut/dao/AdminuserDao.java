package tyut.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tyut.bean.Adminuser;
import tyut.bean.Base;
import tyut.bean.Login;
import tyut.bean.School;

public interface AdminuserDao extends JpaRepository<Adminuser, Integer> {
	Adminuser findByLogin(Login login);
	List<Adminuser> findByNameLike(String name);
	List<Adminuser> findBySchool(School school);

	List<Adminuser> findByBase(Base base);

	List<Adminuser> findByStatus(String status);
}
