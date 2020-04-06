package tyut.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import tyut.bean.Login;

public interface LoginDao extends JpaRepository<Login, Integer> {
	Login findByUsername(String userName);
	List<Login> findByUsernameLike(String userName);
	List<Login> findByStatusLike(String status);
	Login findByUsernameAndPassword(String userName,String password);
	
}
