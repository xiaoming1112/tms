package tyut.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import tyut.bean.School;

public interface SchoolDao extends JpaRepository<School, Integer> {
	List<School> findByNameLike(String name);
}
