package tyut.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tyut.bean.Base;

public interface BaseDao extends JpaRepository<Base, Integer> {
	List<Base> findByNameLike(String name);
}
