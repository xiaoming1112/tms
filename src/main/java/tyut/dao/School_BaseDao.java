package tyut.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tyut.bean.Base;
import tyut.bean.School;
import tyut.bean.School_Base;






public interface School_BaseDao extends JpaRepository<School_Base, Integer> {
	List<School_Base> findBySchool(School school);
	List<School_Base> findByBase(Base base);
}
